package io.github.superjoy0502.paralleldatastructureproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> titles = new ArrayList<String>() {{
        add("The Legend of Zelda");
        add("Zelda II: The Adventure of Link");
        add("The Legend of Zelda: A Link to the Past");
        add("The Legend of Zelda: Link's Awakening");
        add("The Legend of Zelda: Ocarina of Time");
        add("The Legend of Zelda: Majora's Mask");
        add("The Legend of Zelda: Oracle of Seasons");
        add("The Legend of Zelda: Oracle of Ages");
        add("The Legend of Zelda: A Link to the Past & Four Swords");
        add("The Legend of Zelda: The Wind Waker");
        add("The Legend of Zelda: Four Swords Adventures");
        add("The Legend of Zelda: The Minish Cap");
        add("The Legend of Zelda: Twilight Princess");
        add("The Legend of Zelda: Phantom Hourglass");
        add("The Legend of Zelda: Spirit Tracks");
        add("The Legend of Zelda: Skyward Sword");
        add("The Legend of Zelda: A Link Between Worlds");
        add("The Legend of Zelda: Tri Force Heroes");
        add("The Legend of Zelda: Breath of the Wild");
        add("The Legend of Zelda: Tears of the Kingdom");
    }};
    static ArrayList<LocalDate> releaseDates = new ArrayList<LocalDate>() {{
        add(LocalDate.of(1986, 2, 21));
        add(LocalDate.of(1987, 1, 14));
        add(LocalDate.of(1991, 11, 21));
        add(LocalDate.of(1993, 6, 6));
        add(LocalDate.of(1998, 11, 21));
        add(LocalDate.of(2000, 4, 27));
        add(LocalDate.of(2001, 2, 27));
        add(LocalDate.of(2001, 5, 14));
        add(LocalDate.of(2002, 12, 2));
        add(LocalDate.of(2002, 12, 13));
        add(LocalDate.of(2004, 3, 18));
        add(LocalDate.of(2004, 11, 4));
        add(LocalDate.of(2006, 11, 19));
        add(LocalDate.of(2007, 6, 23));
        add(LocalDate.of(2009, 12, 7));
        add(LocalDate.of(2011, 11, 18));
        add(LocalDate.of(2013, 11, 22));
        add(LocalDate.of(2015, 10, 23));
        add(LocalDate.of(2017, 3, 3));
        add(LocalDate.of(2023, 5, 12));
    }};
    static ArrayList<String> platforms = new ArrayList<String>() {{
        add("Famicom Disk System");
        add("Famicom Disk System");
        add("Super Nintendo Entertainment");
        add("Game Boy");
        add("Nintendo 64");
        add("Nintendo 64");
        add("Game Boy Color");
        add("Game Boy Color");
        add("Game Boy Advance");
        add("GameCube");
        add("GameCube");
        add("Game Boy Advance");
        add("GameCube, Wii");
        add("Nintendo DS");
        add("Nintendo DS");
        add("Wii");
        add("Nintendo 3DS");
        add("Nintendo 3DS");
        add("Wii U, Nintendo Switch");
        add("Nintendo Switch");
    }};

    static Scanner scanner;
    static AlgorithmHandler algorithmHandler = new AlgorithmHandler();

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int choice = menu();
        String title;
        int index;
        while (choice != 0) {
            switch (choice) {
                case 1:
                    addGame();
                    break;
                case 2:
                    System.out.print("Enter the title of the game: ");
                    title = scanner.nextLine();
                    index = titles.indexOf(title);
                    if (index == -1) {
                        System.out.println("Game not found.");
                    } else {
                        removeGame(titles.get(index));
                        System.out.println("Game removed.");
                    }
                    break;
                case 3:
                    // Give options to search by title, release date, or platform
                    System.out.println("1. Search by title");
                    System.out.println("2. Search by release date");
                    System.out.println("3. Search by platform");
                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();
                    // Use AlgorithmHandler to search for the game, and print the corresponding game data
                    ArrayList<String> tempTitles;
                    ArrayList<LocalDate> tempReleaseDates;
                    ArrayList<String> tempPlatforms;
                    switch (searchChoice) {
                        case 1:
                            System.out.print("Enter the title of the game: ");
                            title = scanner.nextLine();
                            tempTitles = algorithmHandler.bubbleSortString(titles);
                            tempReleaseDates = algorithmHandler.bubbleSortDate(releaseDates);
                            tempPlatforms = algorithmHandler.bubbleSortString(platforms);
                            index = algorithmHandler.binarySearch(tempTitles, title);
                            if (index == -1) {
                                System.out.println("Game not found.");
                            } else {
                                System.out.println(tempTitles.get(index) + " - " + tempReleaseDates.get(index) + " - " + tempPlatforms.get(index));
                            }
                            break;
                        case 2:
                            System.out.print("Enter the release date of the game (YYYY-MM-DD): ");
                            LocalDate releaseDate = LocalDate.parse(scanner.nextLine());
                            tempTitles = algorithmHandler.bubbleSortString(titles);
                            tempReleaseDates = algorithmHandler.bubbleSortDate(releaseDates);
                            tempPlatforms = algorithmHandler.bubbleSortString(platforms);
                            index = algorithmHandler.binarySearch(tempReleaseDates, releaseDate);
                            if (index == -1) {
                                System.out.println("Game not found.");
                            } else {
                                System.out.println(tempTitles.get(index) + " - " + tempReleaseDates.get(index) + " - " + tempPlatforms.get(index));
                            }
                            break;
                        case 3:
                            System.out.print("Enter the platform of the game: ");
                            String platform = scanner.nextLine();
                            tempTitles = algorithmHandler.bubbleSortString(titles);
                            tempReleaseDates = algorithmHandler.bubbleSortDate(releaseDates);
                            tempPlatforms = algorithmHandler.bubbleSortString(platforms);
                            index = algorithmHandler.binarySearch(tempPlatforms, platform);
                            if (index == -1) {
                                System.out.println("Game not found.");
                            } else {
                                System.out.println(tempTitles.get(index) + " - " + tempReleaseDates.get(index) + " - " + tempPlatforms.get(index));
                            }
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                case 4:
                    System.out.println("1. Print by title");
                    System.out.println("2. Print by release date");
                    System.out.println("3. Print by platform");
                    System.out.print("Enter your choice: ");
                    int printChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (printChoice) {
                        case 1:
                            // Sort titles by title order, then print the corresponding release date and platform as well
                            ArrayList<String> sortedTitles = algorithmHandler.bubbleSortString(titles);
                            for (String sortedTitle : sortedTitles) {
                                index = titles.indexOf(sortedTitle);
                                System.out.println(sortedTitle + " - " + releaseDates.get(index) + " - " + platforms.get(index));
                            }
                            break;
                        case 2:
                            // Sort release dates by release date order, then print the corresponding title and platform as well
                            ArrayList<LocalDate> sortedReleaseDates = algorithmHandler.bubbleSortDate(releaseDates);
                            for (LocalDate sortedReleaseDate : sortedReleaseDates) {
                                index = releaseDates.indexOf(sortedReleaseDate);
                                System.out.println(titles.get(index) + " - " + sortedReleaseDate + " - " + platforms.get(index));
                            }
                            break;
                        case 3:
                            // Sort platforms by platform order, then print the corresponding title and release date as well
                            ArrayList<String> sortedPlatforms = algorithmHandler.bubbleSortString(platforms);
                            for (String sortedPlatform : sortedPlatforms) {
                                index = platforms.indexOf(sortedPlatform);
                                System.out.println(titles.get(index) + " - " + releaseDates.get(index) + " - " + sortedPlatform);
                            }
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
            choice = menu();
        }
    }

    private static int menu() {
        System.out.println("1. Add a game");
        System.out.println("2. Remove a game");
        System.out.println("3. Search for a game");
        System.out.println("4. Print the list");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice;
        while (true) { // Loop until a valid choice is entered
            try {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= 4) {
                    break;
                } else {
                    System.out.print("Invalid choice, please try again: ");
                }
            } catch (Exception e) {
                System.out.print("Invalid choice, please try again: ");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return choice;
    }

    private static LocalDate localDateFromString(String date) {
        String[] dateParts = date.split("/");
        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        return LocalDate.of(year, month, day);
    }

    private static void addGame() {
        System.out.print("Enter the title of the game: ");
        String title = scanner.nextLine();
        System.out.print("Enter the release date of the game (MM/DD/YYYY): ");
        LocalDate releaseDate;
        while (true) { // Keep asking for a date until a valid one is entered
            try {
                releaseDate = localDateFromString(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid date, please try again: ");
            }
        }
        System.out.print("Enter the platform of the game: ");
        String platform = scanner.nextLine();
        titles.add(title);
        releaseDates.add(releaseDate);
        platforms.add(platform);
    }

    private static void removeGame(String title) {
        int index = titles.indexOf(title);
        titles.remove(index);
        releaseDates.remove(index);
        platforms.remove(index);
    }
}