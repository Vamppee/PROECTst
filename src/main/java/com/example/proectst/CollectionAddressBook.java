package com.example.proectst;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook{
    @Override
    public void add(Person person) {
        personList.add(person);

    }

    @Override
    public void update(Person person) {
    }

    @Override
    public void delete(Person person) {
        personList.remove(person);

    }

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public void print(){
        int number = 0;

        for (Person person: personList){
            number++;
            System.out.println(number + ". PIP: " + person.getPip() + "; Phone:" + person.getPhone());
        }
    }

    public void fillTestData(){
        personList.add(new Person("Бик Еміль Іванович", "+380642848536"));
        personList.add(new Person("Пупкін Олег Михайлович", "+38014278536"));
        personList.add(new Person("Джон Микола Остапович", "+380358848536"));
        personList.add(new Person("Кармов Сергій Миколайович", "+380992848536"));
        personList.add(new Person("Щеб Станіслав Олегович", "+380642848536"));
        personList.add(new Person("Порш Павло Павлович", "+38014278536"));
        personList.add(new Person("Багдон Багдан Багданович", "+380358848536"));
        personList.add(new Person("Лазур Ілья Олександрович", "+380992848536"));
        personList.add(new Person("Логус Руслан Русланович", "+380992848536"));


    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }
}
