package co.elastic.apm;

import co.elastic.apm.impl.ErrorCapture;
import co.elastic.apm.impl.Transaction;
import co.elastic.apm.report.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

public class MockReporter implements Reporter {
    private final List<Transaction> transactions = new ArrayList<>();
    private final List<ErrorCapture> errors = new ArrayList<>();

    @Override
    public void report(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public Transaction getFirstTransaction() {
        return transactions.iterator().next();
    }

    @Override
    public void report(ErrorCapture error) {
        errors.add(error);
    }

    public List<ErrorCapture> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public ErrorCapture getFirstError() {
        return errors.iterator().next();
    }

    @Override
    public int getDropped() {
        return 0;
    }

    @Override
    public Future<Void> flush() {
        return null;
    }

    @Override
    public void close() {

    }
}
