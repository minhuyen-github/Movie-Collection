package Hoang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import numberlist.InvalidIndexException;
import numberlist.objectlist.Money;
import numberlist.objectlist.NumericArrayList;
import numberlist.primitivelist.IntegerArrayList;

/**
 * This class is a business class which will interact and handle the user's
 * request by using the code written in here.
 *
 * @author Nomingerel Tserenjav
 * @author Phuong Tran
 * @author Uyen Hoang
 * @version 1.0 06/13/2018
 */
public class MovieCollection {

    //The main lists. This is the data layer.
    ArrayList<String> title;
    ArrayList<String> genre;
    ArrayList<String> rate;
    NumericArrayList price;
    IntegerArrayList year;

    //This is the private data of this class.
    //This is the lists for the cartoon type movie.
    private ArrayList<String> cartTitle = new ArrayList<>();
    private ArrayList<String> cartRate = new ArrayList<>();
    private NumericArrayList cartPrice = new NumericArrayList();
    private IntegerArrayList cartYear = new IntegerArrayList();

    //This is the list for the action type movie.
    private ArrayList<String> actionTitle = new ArrayList<>();
    private ArrayList<String> actionRate = new ArrayList<>();
    private NumericArrayList actionPrice = new NumericArrayList();
    private IntegerArrayList actionYear = new IntegerArrayList();

    //This is the list for the horror type movie.
    private ArrayList<String> horrorTitle = new ArrayList<>();
    private ArrayList<String> horrorRate = new ArrayList<>();
    private NumericArrayList horrorPrice = new NumericArrayList();
    private IntegerArrayList horrorYear = new IntegerArrayList();

    /**
     * This constructor initializes the main movie lists (parallel lists).
     */
    public MovieCollection() {
        title = new ArrayList<>();
        genre = new ArrayList<>();
        rate = new ArrayList<>();
        price = new NumericArrayList();
        year = new IntegerArrayList();
    }

    /**
     * This method will add a new movie and its information into the parallel
     * lists.
     *
     * @param title This is the movie's title.
     * @param genre This is the movie's genre.
     * @param rate This is the movie's rate.
     * @param dollar This is the movie's price (dollar first).
     * @param cent This is the movie's price (cent last).
     * @param year This is the movie's published year.
     */
    public void addMovie(String title, String genre, String rate, long dollar,
            byte cent, int year) {
        (this.title).add(title);
        (this.genre).add(genre);
        (this.rate).add(rate);
        Money money = new Money(dollar, cent);
        price.add(money);
        (this.year).add(year);
    }

    /**
     * This method gets the title from the user, find the index of the title in
     * the title list, delete the info in all of the lists at that index.
     *
     * @param title This is the movie's title that the user want to delete.
     */
    public void deleteMovie(String title) {
        try {
            int index = (this.title).indexOf(title);
            (this.title).remove(title);
            genre.remove(index);
            rate.remove(index);
            price.removeAt(index);
            year.removeAt(index);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method uses the insertion sort to sort the movie lists by their
     * published year. The time complexity is: O(n^2) and the space complexity:
     * 1. Because we're dealing with parallel lists, so it's best if we know the
     * index of the info in the lists because everything is parallel so the
     * index of each piece of the info will be the same. Therefore, this sort
     * keeps track of the index while sorting the year, so other piece of a
     * particular year with a specific index will be moved along with the year.
     * Additionally, we can sort multiple array/lists at the same time.
     */
    public void sortByYear() {
        //insertion sort for the year list.
        for (int i = 1; i < year.getCount(); i++) {
            try {
                int position = i;
                while (position > 0 && year.get(position - 1) > year.get(position)) {
                    swap(year, position, position - 1);
                    swap(title, position, position - 1);
                    swap(genre, position, position - 1);
                    swap(rate, position, position - 1);
                    swap(price, position, position - 1);
                    position = position - 1;
                }
            } catch (InvalidIndexException ex) {
                Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method uses the insertion sort to sort the movie lists by their
     * title. The time complexity is: O(n^2) and the space complexity: 1.
     * Because we're dealing with parallel lists, so it's best if we know the
     * index of the info in the lists because everything is parallel so the
     * index of each piece of the info will be the same. Therefore, this sort
     * keeps track of the index while sorting the year, so other piece of a
     * particular title with a specific index will be moved along with the
     * title. Additionally, we can sort multiple array/lists at the same time.
     */
    public void sortByTitle() {
        //insertion sort for the title list.
        for (int i = 1; i < title.size(); i++) {
            int position = i;
            //ignore the lower case and the upper case.
            while (position > 0 && (title.get(position - 1)).compareToIgnoreCase(title.get(position)) > 0) {
                swap(year, position, position - 1);
                swap(title, position, position - 1);
                swap(genre, position, position - 1);
                swap(rate, position, position - 1);
                swap(price, position, position - 1);
                position = position - 1;
            }
        }
    }

    /**
     * This method swap the two elements at two particular index in the array.
     *
     * @param a This is the IntegerArrayList.
     * @param i This is the index where the element will be swapped.
     * @param j This is the index where the element will be swapped.
     */
    public void swap(IntegerArrayList a, int i, int j) {
        try {
            int temp = (int) a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method swap the two elements at two particular index in the array.
     *
     * @param a This is the String ArrayList.
     * @param i This is the index where the element will be swapped.
     * @param j This is the index where the element will be swapped.
     */
    public void swap(ArrayList<String> a, int i, int j) {
        String temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    /**
     * This method swap the two elements at two particular index in the array.
     *
     * @param a This is the NumericArrayList.
     * @param i This is the index where the element will be swapped.
     * @param j This is the index where the element will be swapped.
     */
    public void swap(NumericArrayList a, int i, int j) {
        try {
            Money temp = (Money) a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
        } catch (InvalidIndexException ex) {
            Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method searches for the index of the genre action in the genre list,
     * then gets the index and use it to get other information of the movie, and
     * stores every action movies in parallel lists.
     */
    public void showAction() {
        for (int i = 0; i < genre.size(); i++) {
            String temp = genre.get(i);
            if (temp.equals("Action")) {
                try {
                    int index = i;
                    actionTitle.add(title.get(index));
                    actionRate.add(rate.get(index));
                    actionPrice.add(price.get(index));
                    actionYear.add(year.get(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * This method gets the title of action movie from the action movie lists.
     *
     * @param index This is the index of a movie in the title list.
     * @return The title at that index.
     */
    public String getTitleAction(int index) {
        return actionTitle.get(index);
    }

    /**
     * This method gets the rate of action movie from the action movie lists.
     *
     * @param index This is the index of a movie in the rate list.
     * @return The rate at that index.
     */
    public String getRateAction(int index) {
        return actionRate.get(index);
    }

    /**
     * This method gets the price of action movie from the action movie lists.
     *
     * @param index This is the index of a movie in the price list.
     * @return The price at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String getPriceAction(int index) throws InvalidIndexException {
        return actionPrice.get(index).toString();
    }

    /**
     * This method gets the published year of action movie from the action movie
     * lists.
     *
     * @param index This is the index of a movie in the year list.
     * @return The year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public int getYearAction(int index) throws InvalidIndexException {
        return (int) actionYear.get(index);
    }

    /**
     * This method gets the representation of year of action movie from the
     * action movie lists.
     *
     * @param index This is the index of a movie in the title list.
     * @return The String representation of the year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String yearToStringAction(int index) throws InvalidIndexException {
        return String.valueOf(actionYear.get(index));
    }

    /**
     * This method gets the size of the action movie lists.
     *
     * @return The size at that index.
     */
    public int sizeAction() {
        return actionTitle.size();
    }

    /**
     * This method will clear the action lists.
     *
     * @throws InvalidIndexException
     */
    public void clearAct() throws InvalidIndexException {
        actionTitle.clear();
        actionRate.clear();
        for (int i = 0; i < actionPrice.getCount(); i++) {
            actionPrice.removeAt(i);
            actionYear.removeAt(i);
        }
    }

    /**
     * This method searches for the index of the genre horror in the genre list,
     * then gets the index and use it to get other information of the movie, and
     * stores every horror movies in parallel lists.
     */
    public void showHorror() {
        for (int i = 0; i < genre.size(); i++) {
            String temp = genre.get(i);
            if (temp.equals("Horror")) {
                try {
                    int index = i;
                    horrorTitle.add(title.get(index));
                    horrorRate.add(rate.get(index));
                    horrorPrice.add(price.get(index));
                    horrorYear.add(year.get(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * This method gets the title of horror movie from the horror movie lists.
     *
     * @param index This is the index of a movie in the title list.
     * @return The title at that index.
     */
    public String getTitleHorror(int index) {
        return horrorTitle.get(index);
    }

    /**
     * This method gets the rate of horror movie from the horror movie lists.
     *
     * @param index This is the index of a movie in the rate list.
     * @return The rate at that index.
     */
    public String getRateHorror(int index) {
        return horrorRate.get(index);
    }

    /**
     * This method gets the price of horror movie from the horror movie lists.
     *
     * @param index This is the index of a movie in the price list.
     * @return The price at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String getPriceHorror(int index) throws InvalidIndexException {
        return horrorPrice.get(index).toString();
    }

    /**
     * This method gets the published year of horror movie from the horror movie
     * lists.
     *
     * @param index This is the index of a movie in the year list.
     * @return The year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public int getYearHorror(int index) throws InvalidIndexException {
        return (int) horrorYear.get(index);
    }

    /**
     * This method gets the representation of year of horror movie from the
     * horror movie lists.
     *
     * @param index This is the index of a movie in the title list.
     * @return The String representation of the year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String yearToStringHorror(int index) throws InvalidIndexException {
        return String.valueOf(horrorYear.get(index));
    }

    /**
     * This method gets the size of the horror movie lists.
     *
     * @return The size at that index.
     */
    public int sizeHorror() {
        return horrorTitle.size();
    }

    /**
     * This method will clear the horror lists.
     *
     * @throws InvalidIndexException
     */
    public void clearHor() throws InvalidIndexException {
        horrorTitle.clear();
        horrorRate.clear();
        for (int i = 0; i < horrorPrice.getCount(); i++) {
            horrorPrice.removeAt(i);
            horrorYear.removeAt(i);
        }
    }

    /**
     * This method searches for the index of the genre cartoon in the genre
     * list, then gets the index and use it to get other information of the
     * movie, and stores every cartoon movies in parallel lists.
     */
    public void showCartoon() {
        for (int i = 0; i < genre.size(); i++) {
            String temp = genre.get(i);
            if (temp.equals("Cartoon")) {
                try {
                    int index = i;
                    cartTitle.add(title.get(index));
                    cartRate.add(rate.get(index));
                    cartPrice.add(price.get(index));
                    cartYear.add(year.get(index));
                } catch (InvalidIndexException ex) {
                    Logger.getLogger(MovieCollection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * This method gets the title of cartoon movie from the cartoon movie lists.
     *
     * @param index This is the index of a movie in the title list.
     * @return The title at that index.
     */
    public String getTitleCart(int index) {
        return cartTitle.get(index);
    }

    /**
     * This method gets the rate of cartoon movie from the cartoon movie lists.
     *
     * @param index This is the index of a movie in the rate list.
     * @return The rate at that index.
     */
    public String getRateCart(int index) {
        return cartRate.get(index);
    }

    /**
     * This method gets the price of cartoon movie from the cartoon movie lists.
     *
     * @param index This is the index of a movie in the price list.
     * @return The price at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String getPriceCart(int index) throws InvalidIndexException {
        return cartPrice.get(index).toString();
    }

    /**
     * This method gets the published year of cartoon movie from the cartoon
     * movie lists.
     *
     * @param index This is the index of a movie in the year list.
     * @return The year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public int getYearCart(int index) throws InvalidIndexException {
        return (int) cartYear.get(index);
    }

    /**
     * This method gets the representation of year of cartoon movie from the
     * cartoon movie lists.
     *
     * @param index This is the index of a movie in the title list.
     * @return The String representation of the year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String yearToStringCart(int index) throws InvalidIndexException {
        return String.valueOf(cartYear.get(index));
    }

    /**
     * This method gets the size of the cartoon movie lists.
     *
     * @return The size at that index.
     */
    public int sizeCart() {
        return cartTitle.size();
    }

    /**
     * This method clears the cartoon movie lists.
     *
     * @throws InvalidIndexException
     */
    public void clearCart() throws InvalidIndexException {
        cartTitle.clear();
        cartRate.clear();
        for (int i = 0; i < cartPrice.getCount(); i++) {
            cartPrice.removeAt(i);
            cartYear.removeAt(i);
        }
    }

    /**
     * This method creates a new file to store the data.
     */
    public void createNewFile() {
        try {
            File myFile = new File("Movie_Collection.txt");
            myFile.createNewFile();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    /**
     * This method save/write the data into the existent file.
     */
    public void saveFile() {
        File fileName = new File("Movie_Collection.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            if (fileName.exists()) {
                for (int i = 0; i < title.size(); i++) {
                    pw.println(title.get(i));
                    pw.println(genre.get(i));
                    pw.println(rate.get(i));
                    pw.println(price.get(i).toString());
                    pw.println(year.get(i));
                }
                pw.close();
            }
        } catch (IOException | InvalidIndexException ex) {
            ex.getMessage();
        }
    }

    /**
     * This method gets the title of a movie at a specific index.
     *
     * @param index The position of the title in the title list.
     * @return the title at that index.
     */
    public String getTitle(int index) {
        return title.get(index);
    }

    /**
     * This method gets the genre of a movie at a specific index.
     *
     * @param index The position of the title in the genre list.
     * @return the genre at that index.
     */
    public String getGenre(int index) {
        return genre.get(index);
    }

    /**
     * This method gets the rate of a movie at a specific index.
     *
     * @param index The position of the rate in the rate list.
     * @return the rate at that index.
     */
    public String getRate(int index) {
        return rate.get(index);
    }

    /**
     * This method gets the price of a movie at a specific index.
     *
     * @param index The position of the price in the price list.
     * @return the price at that index.
     * @throws numberlist.InvalidIndexException
     */
    public String getPrice(int index) throws InvalidIndexException {
        return price.get(index).toString();
    }

    /**
     * This method gets the published year of a movie at a specific index.
     *
     * @param index The position of the year in the year list.
     * @return the year at that index.
     * @throws numberlist.InvalidIndexException
     */
    public int getYear(int index) throws InvalidIndexException {
        return (int) year.get(index);
    }

    /**
     * This method returns the String representation of the year.
     *
     * @param index The position of the year in the list.
     * @return The String representation of the year.
     * @throws InvalidIndexException
     */
    public String yearToString(int index) throws InvalidIndexException {
        return String.valueOf(year.get(index));
    }

    /**
     * This method gets the size of the title list which will be the same for
     * other lists.
     *
     * @return the size of the title list.
     */
    public int size() {
        return title.size();
    }

    /**
     * This method gets the reference to the entire title list elements.
     *
     * @return an array list which contains reference to the title list.
     */
    public ArrayList<String> getTitles() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            list.add(title.get(i));
        }
        return list;
    }

    /**
     * This method gets the reference to the entire genre list elements.
     *
     * @return an array list which contains reference to the genre list.
     */
    public ArrayList<String> getGenres() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            list.add(title.get(i));
        }
        return list;
    }

    /**
     * This method gets the reference to the entire rate list elements.
     *
     * @return an array list which contains reference to the rate list.
     */
    public ArrayList<String> getRates() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            list.add(title.get(i));
        }
        return list;
    }

    /**
     * This method gets the reference to the entire price list elements.
     *
     * @return an array list which contains reference to the price list.
     * @throws numberlist.InvalidIndexException
     */
    public NumericArrayList getPrices() throws InvalidIndexException {
        NumericArrayList list = new NumericArrayList();
        for (int i = 0; i < price.getCount(); i++) {
            list.add(price.get(i));
        }
        return list;
    }

    /**
     * This method gets the reference to the entire year list elements.
     *
     * @return an array list which contains reference to the year list.
     * @throws numberlist.InvalidIndexException
     */
    public IntegerArrayList getYears() throws InvalidIndexException {
        IntegerArrayList list = new IntegerArrayList();
        for (int i = 0; i < price.getCount(); i++) {
            list.add(year.get(i));
        }
        return list;
    }

    /**
     * This method reads the data which is stored in a file and add each data to
     * their respective array/array lists.
     */
    public void readFile() {
        File fileName = new File("Movie_Collection.txt");
        if (fileName.exists()) {
            int index = 0;
            try (Scanner scanFile = new Scanner(fileName)) {
                while (scanFile.hasNext()) {
                    title.add(index, scanFile.nextLine());
                    genre.add(index, scanFile.nextLine());
                    rate.add(index, scanFile.nextLine());
                    price.add(index, valueOfPrice(scanFile.nextLine()));
                    year.add(index, Long.valueOf(scanFile.nextLine()));
                    index++;
                }
            } catch (FileNotFoundException | InvalidIndexException ex) {
                ex.getMessage();
            }
        } else {
            createNewFile();
        }
    }

    /**
     * This method shows the entire movie list.
     *
     * @throws InvalidIndexException
     */
    public void showAllMovies() throws InvalidIndexException {
        getTitles();
        getGenres();
        getRates();
        getPrices();
        getYears();
    }

    /**
     * This method take a String representation of the price, find the dollars
     * and the cents, and create a Money object to put it in the price array.
     *
     * @param price This is the String representation of the price.
     * @return the Money object with dollars and cents seperatedly.
     */
    public Money valueOfPrice(String price) {
        Money money;
        if (price.contains("$") && price.contains(".")) {
            int indexOfDot = price.indexOf(".");
            Long dollars = Long.valueOf(price.substring(1, indexOfDot));
            Byte cents = Byte.valueOf(price.substring(indexOfDot + 1));
            money = new Money(dollars, cents);
            return money;
        } else {
            return money = new Money(0, (byte) 0);
        }
    }
}
