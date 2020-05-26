package Model;

import Helper.Address;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Marker implements Serializable {

    private static final long serialVersionUID = 1L;

    private static double maxWeightInKg = 7; // a

    private static List<Marker> markers = new ArrayList<>(); // ekstensja klasy

    private Player player; // asocjacja binarna 1

    private String name;
    private double weight;
    private double prize;
    private Address productionPlace; // atrybut złożony - miejsce produkcji
    private String previousName; // atrybut opcjonalny - poprzednia nazwa markera
    private List<String> availableUpgrades; // atrybut powtarzalny
    private LocalDate reviewData; // termin wygasnięcia przeglądu
    private boolean hasActualReview; // atrybut wyliczalny - sprawdzanie czy przegląd jest akutalny

    public Marker() {
    }

    public Marker(String name, double weight, double prize) {
        this.name = name;
        this.weight = weight;
        this.prize = prize;
    }

    private static void addMarker(Marker marker){
        markers.add(marker);
    }
    private static void removeMarker(Marker marker){
        markers.add(marker);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(markers);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        markers = (ArrayList<Marker>) stream.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setPreviousName(this.name);
        this.name = name;

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public Address getProductionPlace() {
        return productionPlace;
    }

    public void setProductionPlace(Address productionPlace) {
        this.productionPlace = productionPlace;
    }

    public String getPreviousName() {
        return previousName;
    }

    public void setPreviousName(String previousName) {
        if(previousName != null) {
            this.previousName = previousName;
        }
    }

    public List<String> getAvailableUpgrades() {
        return availableUpgrades;
    }

    public void setAvailableUpgrades(List<String> availableUpgrades) {
        this.availableUpgrades = availableUpgrades;
    }

    public LocalDate getReviewData() {
        return reviewData;
    }

    public void setReviewData(LocalDate reviewData) {
        this.reviewData = reviewData;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) { // połączenie zwrotne
        if(this.player != null) {
            this.player.removeMarker(this);
        }
        player.addMarker(this);
        this.player = player;
    }

    public boolean isHasActualReview() {
        LocalDate current = LocalDate.now();
        if(reviewData.isAfter(current)){
            hasActualReview = true;
        }else {
            hasActualReview = false;
        }
        return hasActualReview;
    }
    public static double getMaxWeightInKg() {
        return maxWeightInKg;
    }

    public static void setMaxWeightInKg(double maxWeightInKg) {
        Marker.maxWeightInKg = maxWeightInKg;
    }

    public void setHasActualReview(boolean hasActualReview) {
        this.hasActualReview = hasActualReview;
    }
    public static List<Marker> findNoActualMarkers(){ // metoda klasowa - zwaraca liste markerów bez aktualnego przeglądu
        if(markers != null && !markers.isEmpty()){
            return markers.stream().filter(marker -> !marker.hasActualReview).collect(Collectors.toList());
        }else {
            return null;
        }
    }



    public static List<Marker> findNoActualMarkers(double minWeight){ // metoda klasowa - zwaraca liste markerów bez aktualnego przeglądu dla ktorych waga magazynku jest nie przekraczy 4

        if (markers != null && !markers.isEmpty()) {
            return markers.stream().filter(marker -> !marker.hasActualReview && marker.getWeight() > minWeight).collect(Collectors.toList());
        } else {
            return null;
        }

    }


    public static void showMarkers(){ // wyświetalnie ekstensji
        System.out.println("Markery: ");
        for( Marker marker : markers){
            System.out.println(marker);
        }
    }
    public static List<Marker> getMarkers() {
        return markers;
    }

    public static void setMarkers(List<Marker> markers) {
        Marker.markers = markers;
    }
    public static void clearExtent(){
        markers.clear();
    }

    @Override
    public String toString() {
        return "Marker\n" +
                "player=" + player.getName() +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", prize=" + prize;
    }
}
