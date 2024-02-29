package service.impl;

import enums.Role;
import exception.LibraryException;
import model.Library;
import model.User;
import service.BorrowerService;
import java.util.PriorityQueue;
import java.util.Queue;


public class BorrowerServiceImpl implements BorrowerService {
    @Override
        public void requestBook(String titleOfBook, User user, Library library) {
            PriorityQueue<User> borrowers = new PriorityQueue<>((p1, p2) -> {
                int roleValue1 = getRoleValue(p1.getRole());
                int roleValue2 = getRoleValue(p2.getRole());
                if (roleValue1 == roleValue2) {
                    return Integer.compare(p1.getOrder(), p2.getOrder());
                }
                return roleValue1 - roleValue2;
            });
            borrowers.add(user);
            borrowers.addAll(library.getBorrowers());
            library.setBorrowers(borrowers);
        System.out.println(user.getName() + " has joined the queue");
        }

        @Override
        public void requestBookFIFO(String titleOfBook, User user, Library library) {
            Queue<User> userQueueFIFO = library.getUserQueueFIFO();
            userQueueFIFO.add(user);
            library.setUserQueueFIFO(userQueueFIFO);
        }

        private int getRoleValue (Role role) {
            return switch (role) {
                case TEACHER -> 1;
                case SNR_STUDENT -> 2;
                case JNR_STUDENT -> 3;
                default -> throw new LibraryException("Unknown role: " + role);
            };
        }

    }





