package ch.heigvd.gen2019;

public enum Color {

    BLUE {
        @Override
        public String toString() {
            return "blue";
        }
    },
    RED {
        @Override
        public String toString() {
            return "red";
        }
    },
    YELLOW {
        @Override
        public String toString() {
            return "yellow";
        }
    },
    NONE {
        @Override
        public String toString() {
            return "no color";
        }
    };

    public abstract String toString();
}
