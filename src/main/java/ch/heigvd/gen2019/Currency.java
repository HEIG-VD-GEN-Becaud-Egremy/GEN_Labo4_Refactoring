package ch.heigvd.gen2019;

public enum Currency {
    TWD {
        @Override
        public String toString() {
            return "TWD";
        }
    },
    SGD {
        @Override
        public String toString() {
            return "SGD";
        }
    };

    public abstract String toString();
}
