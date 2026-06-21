public class BuilderPattern {
    static class Computer {
        private String cpu, ram, storage, gpu;
        private boolean bluetooth;
        private Computer(Builder b) {
            this.cpu = b.cpu; this.ram = b.ram;
            this.storage = b.storage; this.gpu = b.gpu;
            this.bluetooth = b.bluetooth;
        }
        public String toString() {
            return "Computer{CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + ", GPU=" + gpu + ", BT=" + bluetooth + "}";
        }
        static class Builder {
            private String cpu, ram, storage = "256GB", gpu = "Integrated";
            private boolean bluetooth = false;
            Builder(String cpu, String ram) { this.cpu = cpu; this.ram = ram; }
            Builder setStorage(String s) { this.storage = s; return this; }
            Builder setGPU(String g) { this.gpu = g; return this; }
            Builder setBluetooth(boolean b) { this.bluetooth = b; return this; }
            Computer build() { return new Computer(this); }
        }
    }
    public static void main(String[] args) {
        Computer gaming = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD").setGPU("RTX 4080").setBluetooth(true).build();
        Computer basic = new Computer.Builder("Intel i3", "8GB").build();
        System.out.println("Gaming: " + gaming);
        System.out.println("Basic: " + basic);
    }
}