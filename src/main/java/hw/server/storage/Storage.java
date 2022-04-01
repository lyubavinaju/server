package hw.server.storage;

import hw.server.model.Company;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Company> companies = new HashMap<>();

    public static boolean addCompany(Company company) {
        if (companies.containsKey(company.getName())) {
            return false;
        }
        companies.put(company.getName(), company);
        return true;
    }

    public static Company getCompany(String name) {
        return companies.getOrDefault(name, null);
    }

    public static long putStocks(String name, long count) {
        Company company = companies.getOrDefault(name, new Company(name));
        company.setCount(company.getCount() + count);
        companies.put(name, company);
        return company.getPrice();
    }

    public static void popStocks(String name, long count, Long price) throws Exception {
        Company company = companies.getOrDefault(name, null);
        if (company == null) {
            throw new Exception("Company not found.");
        }
        if (company.getCount() < count) {
            throw new Exception("Company doesn't have this count of stocks.");
        }
        if (company.getPrice() != price) {
            throw new Exception("Price changed. Try again.");
        }
        company.setCount(company.getCount() - count);
    }

    public static boolean changePrice(String name, Long price) {
        Company company = companies.getOrDefault(name, null);
        if (company == null) return false;
        company.setPrice(price);
        return true;
    }

    public static Long getPrice(String name) {
        Company company = companies.getOrDefault(name, null);
        if (company == null) return null;
        return company.getPrice();
    }

    public static Long getCount(String name) {
        Company company = companies.getOrDefault(name, null);
        if (company == null) return null;
        return company.getCount();
    }
}
