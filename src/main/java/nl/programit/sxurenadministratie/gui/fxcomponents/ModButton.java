package nl.programit.sxurenadministratie.gui.fxcomponents;

import javafx.scene.control.Button;

public class ModButton extends Button {
    String mod;
    ModButton(String mod){
        super(mod);
        this.mod = mod;
    }
}
