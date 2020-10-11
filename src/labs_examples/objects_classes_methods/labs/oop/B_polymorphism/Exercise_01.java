package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Exercise_01 {
    public static void main(String[] args) {
        Synthesizer nord = new Synthesizer(61);
        Synthesizer korg = new Synthesizer();
        nord.play();
        Ukulele uke = new Ukulele();
        uke.powerOn();
        System.out.println();

        CurrentInstrument instrument = new CurrentInstrument(korg);
        instrument.play();
        instrument.setInstrument(uke);
        instrument.play();
    }
}

interface Instrument {
    public void play();
    public default void powerOn() {
        System.out.println("Acoustic Instruments don't need to be powered on.");
    }
}

class CurrentInstrument {

    Instrument instrument;

    public CurrentInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void play() {
        instrument.powerOn();
        instrument.play();
    }
}

class Synthesizer implements Instrument {

    int keys;

    // Do all abstract methods required by and implemented interface need @Override?

    @Override
    public void play() {
        System.out.println("Playing Synthesizer");
    }
    @Override
    public void powerOn() {
        System.out.println("Powered on Synthesizer");
    }

    // Overloaded constructors

    public Synthesizer(int keys) {
        this.keys = keys;
    }

    public Synthesizer() {
    }
}

class DrumMachine implements Instrument {
    @Override
    public void powerOn() {
        System.out.println("Powered on Drum Machine");
    }
    @Override
    public void play() {
        System.out.println("Playing Drum Machine");
    }
}

class Ukulele implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing Ukulele");
    }
}