package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class defining the Template Method pattern for report generation.
 * Subclasses implement loadData(), formatHeader(), formatBody(), and formatFooter().
 */
public abstract class Report {

    /**
     * Template method — defines the fixed workflow for generating any report.
     */
    public final void generateReport() {
        loadData();
        formatHeader();
        formatBody();
        formatFooter();
    }

    /** Loads report-specific data. */
    protected abstract void loadData();

    /** Prints the report header. */
    protected abstract void formatHeader();

    /** Prints the report body. */
    protected abstract void formatBody();

    /** Prints the report footer. */
    protected abstract void formatFooter();
}
