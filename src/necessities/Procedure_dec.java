/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package necessities;

/**
 *
 * @author ambarsuarez
 */
public class Procedure_dec {
    Procedure_d pd;
    Block_p blockp;

    public Procedure_dec(Procedure_d pd, Block_p blockp) {
        this.pd = pd;
        this.blockp = blockp;
    }

    public Procedure_d getPd() {
        return pd;
    }

    public void setPd(Procedure_d pd) {
        this.pd = pd;
    }

    public Block_p getBlockp() {
        return blockp;
    }

    public void setBlockp(Block_p blockp) {
        this.blockp = blockp;
    }
    
    
}
