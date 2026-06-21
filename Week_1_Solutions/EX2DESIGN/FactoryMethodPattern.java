public class FactoryMethodPattern {
    interface Document { void open(); void save(); void close(); }
    static class Word implements Document {
        public void open() { System.out.println("Opening Word..."); }
        public void save() { System.out.println("Saving Word..."); }
        public void close() { System.out.println("Closing Word..."); }
    }
    static class Pdf implements Document {
        public void open() { System.out.println("Opening PDF..."); }
        public void save() { System.out.println("Saving PDF..."); }
        public void close() { System.out.println("Closing PDF..."); }
    }
    static class Excel implements Document {
        public void open() { System.out.println("Opening Excel..."); }
        public void save() { System.out.println("Saving Excel..."); }
        public void close() { System.out.println("Closing Excel..."); }
    }
    static abstract class Factory { abstract Document create(); }
    static class WordFactory extends Factory { Document create() { return new Word(); } }
    static class PdfFactory extends Factory { Document create() { return new Pdf(); } }
    static class ExcelFactory extends Factory { Document create() { return new Excel(); } }
    public static void main(String[] args) {
        Factory f = new WordFactory();
        Document d = f.create();
        d.open(); d.save(); d.close();
        f = new PdfFactory();
        d = f.create();
        d.open(); d.save(); d.close();
        f = new ExcelFactory();
        d = f.create();
        d.open(); d.save(); d.close();
    }
}