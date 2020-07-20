package KnightVs.Hydra;

public class Hydra{
    protected int numHeads;
    protected int numTails;

    public Hydra(int H, int T){
        this.numHeads = H;
        this.numTails = T;
    }

    public boolean move(int moveNum){
        switch(moveNum) {
            case 1:
                if (this.numHeads == 0) {
                    return false;
                }
                break;
            case 2:
                if(this.numTails == 0){
                    return false;
                }
                this.numTails ++;
                break;
            case 3:
                if(this.numHeads <= 1){
                    return false;
                }
                this.numHeads -= 2;
                break;
            case 4:
                if(this.numTails <= 1){
                    return false;
                }
                this.numTails -= 2;
                this.numHeads++;
                break;
        }
        return true;
    }

    public void displayHydra(){
        System.out.println("The Hydra:");
        System.out.println("\tHeads: " + this.numHeads + "\t\tTails: " + this.numTails);
    }

    public boolean canKill(){
        return(!(this.numHeads == 1 && this.numTails == 0));
    }

    public boolean hydraAlive(){
        return (this.numHeads > 0 || this.numTails > 0);
    }
}
