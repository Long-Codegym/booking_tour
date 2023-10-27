package com.book_tour.model.dto;

import com.book_tour.model.Role;
import com.book_tour.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private long id;
    private String username;
    private String fullName;
    private String avatar;
    private String email;
    private String address;
    private long balance;
    private String token;
    private Role role;
    private Status status;
    private Boolean isActive;
}
