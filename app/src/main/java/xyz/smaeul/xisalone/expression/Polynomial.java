package xyz.smaeul.xisalone.expression;

import java.util.LinkedList;

/**
 * Created by Madi on 10/14/16.
 * Refactored by Samuel on 10/15/16
 */

public class Polynomial {

    private LinkedList<Term> terms;

    public Polynomial() {
        terms = new LinkedList<>();
    }

    public void add(Term t) {
        boolean found = false;
        for (Term term : terms) {
            if (term.exponent == t.exponent) {
                term.coefficient += t.coefficient;
                found = true;
                break;
            }
        }
        if (found == false) {
            terms.add(t);
        }
    }

    public LinkedList<Term> getTerms() {
        return new LinkedList<Term>(terms);
    }

    public void multiply(Term t) {
        for (Term term : terms) {
            term.coefficient *= t.coefficient;
            term.exponent += t.exponent;
        }
    }

    public void subtract(Term t) {
        add(new Term(-t.coefficient, t.exponent));
    }
}