import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class DeveloperController {

    protected DeveloperController () {

        readLine();
    }
    public void readLine (){

        System.out.println("Укажите действие");
        System.out.println("1. Создать аккаунт\n2. Вывести информацию об аккаунте\n3. Редактировать\n4. Удалить аккаунт\n5. Выйти");

        String userInfo = new Scanner(System.in).next();

        switch (userInfo) {

            case "1" -> {

                if (!createDeveloper()) {

                    System.out.println("Не удалось создать акkаунт");
                } else {

                    System.out.println("Аккаунт создан");
                }
                readLine();
            }

            case "2" -> {

                DeveloperView developerView = new DeveloperView();
            }

            case "3" -> {

            }

            case "4" -> {

            }

            case "5" -> System.out.println("GLHF");

            default -> {

                System.out.println("Неверное значение!");
                readLine();
            }
        }
    }

    public boolean createDeveloper (){

        String filePath = "developers.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Developer> objList;

        try (Reader reader = new FileReader(filePath)) {

            Type listType = new TypeToken<List<Developer>>() {}.getType();

            objList = gson.fromJson(reader, listType);

        } catch (FileNotFoundException e) {

            System.out.println("Файл не найден.");
            return false;

        } catch (IOException e) {

            System.out.println("Ошибка чтения файла.");
            return false;
        }

        if (objList == null) objList = new ArrayList<>();

        objList.add(new Developer());

        try (Writer writer = new FileWriter(filePath)) {

            List<String> gsonList = new ArrayList<>(objList.size());

            Gson g = new Gson();

            for (Developer x: objList) {

                gsonList.add(g.toJson(x));
            }

            g.toJson(gsonList);

            gson.toJson(g, writer);

            return true;

        } catch (FileNotFoundException e) {

            System.out.println("Файл не найден.");
            return false;

        } catch (IOException e) {

            System.out.println("Ошибка записи в файл.");
            return false;
        }
    }
}
