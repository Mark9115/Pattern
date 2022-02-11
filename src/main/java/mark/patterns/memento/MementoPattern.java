package mark.patterns.memento;

import java.util.ArrayList;

class Year{
    private String year;

    public void set(String time){
        System.out.println("Setting year to " + time);
        this.year = time;
    }

    public Memento saveToMemento(){
        System.out.println("Saving year to Memento");
        return new Memento(year);
    }

    public void restoreFromMemento(Memento memento){
        year = memento.getSavedTime();
        System.out.println("Year restored: " + year);
    }

    public static class Memento{
        private final String year;

        public Memento(String yearToSave){
            year = yearToSave;
        }

        public String getSavedTime(){
            return year;
        }
    }
}

class MementoPattern{
    public static void main(String[] args){
        ArrayList<Year.Memento> savedYears = new ArrayList<>();

        Year year = new Year();

        year.set("1990 year");
        savedYears.add(year.saveToMemento());
        year.set("1992 year");
        savedYears.add(year.saveToMemento());
        year.set("1995 year");
        savedYears.add(year.saveToMemento());
        year.set("1996 year");

        year.restoreFromMemento(savedYears.get(1));
    }
}

