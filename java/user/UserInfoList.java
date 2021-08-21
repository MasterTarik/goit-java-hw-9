package user;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfoList {
    final static String inFileDirectory2 = "src\\main\\resources\\file2.txt";
    final static String outFileDirectory = "src\\main\\resources\\user.json";

    private ArrayList<Node> users = new ArrayList<>();

    public UserInfoList() {
        this.users = new ArrayList<>();
    }

    public UserInfoList(String name, int age) {
        Node user = new Node(name, age);
        users.add(user);
    }

    public void addUser(String name, int id) {
        this.users.add(new Node(name, id));
    }

    public ArrayList getData() {
        ArrayList<String> dataList = new ArrayList<>();

        try {
            Path path = Paths.get(inFileDirectory2);
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()) {
                String str = scanner.next().strip();
                if (!str.equals("")) {
                    dataList.add(str);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        dataList.remove(0);
        return dataList;
    }

    public String wrapper() throws IOException {
        ArrayList<String> userList = getData();
        for (int i = 0; i < userList.size(); i++) {
            String[] userNameId = userList.get(i).split(" ");
            addUser(userNameId[0], Integer.parseInt(userNameId[1]));
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(outFileDirectory), users);
        return new ObjectMapper().writeValueAsString(users);
    }

    @JsonPropertyOrder({"name", "id"})
    class Node {
        private String name;
        private int age;


        public Node(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
