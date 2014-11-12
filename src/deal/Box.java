package deal;

public class Box {

    private int id;
    private int value;

    private boolean opened;

    public Box(int id, int value) {
        setId(id);
        setValue(value);
        setOpened(false);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() throws IllegalStateException {

        if(!opened) {
            throw new IllegalStateException();
        } else {
        return value;
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void setOpened(boolean isOpen) {
        this.opened = isOpen;
    }

    @Override
    public String toString() {
        try {
            return getId() + " : " + isOpened() + " : " + getValue();
        } catch (IllegalStateException e) {
            return String.valueOf(getId() + " : " + isOpened());
        }
    }


    public boolean isOpened() {
        return opened;
    }

    public void open() {
        setOpened(true);
    }
}
