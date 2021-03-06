//Marketer.java
//Oasys Okubo
//ookubo
//Program 5
//This program implements 7 classes and simulates how a company calculates
//a payroll for different types and levels of employees.

package employee;

public class Marketer extends Employee {
    
    Marketer(int yearsWorked) {                         // constructor 
        super(yearsWorked);
    } 
    
    private final double CLIENT_BONUS = 2000;           // per new client 
    private final int PAID_VACATION = 10;               // days
    private final int UNPAID_VACATION = 10;             // days
    private final double HEALTH_INSURANCE = 10000;      // $/year 
    private final double INCOME = 100000;               // $/year
    
    private int numBonuses;                             // keeps track of how many commission
                                                        // based bonuses the employee received. 
    
    int getNumBonuses() {                               // getter method for numBonuses
        return numBonuses;
    }
    
    void setNumBonuses(int numBonuses) {                // setter method for numBonuses
        this.numBonuses = numBonuses;
    }
    
    private int usedUnpaidVacation;                     // keeps track of how much
                                                        // unpaid vacation has been used. 
    
    int getUsedUnpaidVacation() {                       // getter method for usedUnpaidVacation
        return usedUnpaidVacation;
    }
    
    void setUsedUnpaidVacation(int usedUnpaidVacation) {// setter method for usedUnpaidVacation
        this.usedUnpaidVacation = usedUnpaidVacation;
    }
    
    private int usedVacation;                           // keeps track of how much paid vacation
                                                        // has been used.
    
    int getUsedVacation() {                             // getter method for usedVacation
        return usedVacation;
    }
    
    void setUsedVacation(int usedVacation) {            // setter method for usedVacation
        this.usedVacation = usedVacation;   
    }
    
    void signDeal() {                                   // adds one to numBonuses.
        numBonuses++;
    } 
    
    void usePaidVacation() {                            // adds one to usedVacation 
        usedVacation++;
    }
    
    void useUnpaidVacation() {                          // adds one to // usedUnpaidVacation 
        usedUnpaidVacation++;
    }
    
    void workYear() {                                   // Adds one to yearsWorked.
        super.setYears(super.getYears() + 1);
    }
    
    @Override
    double YTDValue() {
        return ((CLIENT_BONUS * numBonuses) + (HEALTH_INSURANCE + INCOME) + 
                (PAID_VACATION * (INCOME / 260)));
    }
        /* Overridden from Employee class. This is calculated by taking the sum of:
        CLIENT_BONUS * numBonuses
        HEALTH_INSURANCE
        INCOME
        PAID_VACATION * (INCOME / 260) */
    
    @Override
    int yearsTillRetirement() {
        int calculateYearsTillRetirement = (int)(Math.round((((float)35 - ((float)super.getYears() + 
                ((float)usedUnpaidVacation / 260) + (((float)usedVacation / 260) * 2))))));
        
        return calculateYearsTillRetirement;
    }
        /* Overridden from Employee class. This should be rounded up to the nearest int. 
        The calculation should take place as floating point arithmetic to ensure precision 
        (hint: cast as double where necessary). This number should not be below zero. 
        This is calculated by: 35 – (yearsWorked + (usedUnpaidVacation / 260) + 
        ((usedVacation / 260) * 2)) */
}
