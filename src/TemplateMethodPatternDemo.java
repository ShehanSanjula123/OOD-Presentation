abstract class DataProcessor {
    // Template method
    public final void process() {
        loadData();
        processData();
        saveData();
    }

    abstract void loadData();
    abstract void processData();

    // Common method
    void saveData() {
        System.out.println("Saving data to the database.");
    }
}

class ExcelDataProcessor extends DataProcessor {
    @Override
    void loadData() {
        System.out.println("Loading data from Excel file.");
    }

    @Override
    void processData() {
        System.out.println("Processing Excel data.");
    }
}

class CSVDataProcessor extends DataProcessor {
    @Override
    void loadData() {
        System.out.println("Loading data from CSV file.");
    }

    @Override
    void processData() {
        System.out.println("Processing CSV data.");
    }
}

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        DataProcessor excelProcessor = new ExcelDataProcessor();
        excelProcessor.process();

        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();
    }
}
