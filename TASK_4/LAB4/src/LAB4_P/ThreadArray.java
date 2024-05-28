package LAB4_P;

public class ThreadArray extends Thread {

    protected int maxSize;
    protected int minSize;

    public ThreadArray(String name, int _maxSize, int _minSize) {
        super(name);
        this.maxSize = _maxSize;
        this.minSize = _minSize;
    }


    public double getMaxSize() {
        return this.maxSize;
    }

    public double getMinSize() {
        return this.minSize;
    }
}

class ThreadInt extends ThreadArray {
    private int[] tab;
    protected int max;
    protected int min;

    public ThreadInt(String name, int _maxSize, int _minSize, int[] _tab) {
        super(name, _maxSize, _minSize);
        this.tab = _tab;
        start();
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    @Override
    public void run() {
        max = tab[0];
        min = tab[0];

        // System.out.println(this.getName() + " range of search in the array: " + minSize + " - " + maxSize);

        for (int i = minSize; i < maxSize; i++) {
            if (tab[i] > max) max = tab[i];
            if (tab[i] < min) min = tab[i];
        }
        //System.out.println(this.getName() + " min: " + this.getMin() + " max: " + this.getMax());
    }
}

class ThreadDouble extends ThreadArray {
    private double[] tab;
    protected double max;
    protected double min;

    public ThreadDouble(String name, int _maxSize, int _minSize, double[] _tab) {
        super(name, _maxSize, _minSize);
        this.tab = _tab;
        start();
    }

    public double getMax() {
        return this.max;
    }

    public double getMin() {
        return this.min;
    }

    @Override
    public void run() {
        max = tab[0];
        min = tab[0];

        // System.out.println(this.getName() + " range of search in the array: " + minSize + " - " + maxSize);

        for (int i = minSize; i < maxSize; i++) {
            if (tab[i] > max) max = tab[i];
            if (tab[i] < min) min = tab[i];
        }
        //System.out.println(this.getName() + " min: " + this.getMin() + " max: " + this.getMax());
    }
}
