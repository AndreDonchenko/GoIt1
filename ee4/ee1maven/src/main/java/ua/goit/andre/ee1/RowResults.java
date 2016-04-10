package ua.goit.andre.ee1;

class RowResults {
    private final String name;
    private long addR;
    private long getR;
    private long removeR;
    private long containsR;
    private long populateR;
    private long iteratorAddR;
    private long iteratorRemoveR;

    public String toString(int divider) {
        StringBuilder sb = new StringBuilder("| ");
        sb.append(String.format("%11s",name)).append(" | ");
        sb.append(String.format("%10d",addR / divider)).append(" | ");
        sb.append(String.format("%10s",getR / divider)).append(" | ");
        sb.append(String.format("%10s",removeR / divider)).append(" | ");
        sb.append(String.format("%10s",containsR / divider)).append(" | ");
        sb.append(String.format("%10s",populateR / divider)).append(" | ");
        sb.append(String.format("%10s",iteratorAddR / divider)).append(" | ");
        sb.append(String.format("%10s",iteratorRemoveR / divider)).append(" |");
        return sb.toString();
    }

    public RowResults(String name) {
        this.name = name;
    }

    public long getAddR() {
        return addR;
    }

    public void setAddR(long addR) {
        this.addR = addR;
    }

    public long getGetR() {
        return getR;
    }

    public void setGetR(long getR) {
        this.getR = getR;
    }

    public long getRemoveR() {
        return removeR;
    }

    public void setRemoveR(long removeR) {
        this.removeR = removeR;
    }

    public long getContainsR() {
        return containsR;
    }

    public void setContainsR(long containsR) {
        this.containsR = containsR;
    }

    public long getPopulateR() {
        return populateR;
    }

    public void setPopulateR(long populateR) {
        this.populateR = populateR;
    }

    public long getIteratorAddR() {
        return iteratorAddR;
    }

    public void setIteratorAddR(long iteratorAddR) {
        this.iteratorAddR = iteratorAddR;
    }

    public long getIteratorRemoveR() {
        return iteratorRemoveR;
    }

    public void setIteratorRemoveR(long iteratorRemoveR) {
        this.iteratorRemoveR = iteratorRemoveR;
    }

    public String getName() {
        return name;
    }
}
