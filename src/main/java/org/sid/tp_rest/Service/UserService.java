package org.sid.tp_rest.Service;


import org.sid.tp_rest.Model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    public UserService() {
        userList.addAll(Arrays.asList(
                new User(1, "Mohammed", "mhd@mail.com"),
                new User(2, "Moad", "moad@mail.com"),
                new User(3, "Sana", "sana@mail.com"),
                new User(4, "Ahlam", "ahlam@mail.com")
        ));
    }

    public List<User> getUsers() { return userList; }

    public User getUser(Integer id) {
        return userList.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public String addUser(User user) {
        userList.add(user);
        return "L'utilisateur " + user.getId() + " est bien ajouté !";
    }

    public String updateUser(int id, User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                userList.set(i, user);
                return "L'utilisateur " + id + " est bien modifié !";
            }
        }
        return "L'utilisateur " + id + " n'existe pas !";
    }

    public void suppUser(Integer id) {
        userList.removeIf(u -> u.getId() == id);
    }
}
