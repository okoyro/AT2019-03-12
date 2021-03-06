package by.it.vshchur.at07;

public class Scalar extends Var {

    double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar o = (Scalar) other;
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return super.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar o = (Scalar) other;
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return new Scalar(-1).mul(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar) other).value);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value / ((Scalar) other).value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
