package hw.server.model;

import java.util.Objects;

public class Company {
    private static final long DEFAULT_PRICE = 1000;
    private final String name;
    long price = DEFAULT_PRICE;
    long count = 0;

    public void setPrice(long price) {
        this.price = price;
    }

    public Company(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
