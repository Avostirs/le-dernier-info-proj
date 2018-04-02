import java.util.TimerTask;
import java.util.Timer;


//info 1 : une classe qui prend un boom en parametre, et qui a une methode run() qui sera reveillee par le timer( methode .schedule)
//info 2: cette classe est un type de TimerTask, car la methode .schedule prend en parametre un TimerTask 
//info 3: le .shedule va reveiller en fait repeter la methode run() du TimerTask
//info 4: le .schedule( TimerTask , temps de debut de l'appel de la mthode run() , periode de repetition de la methode run() ) ---) les parametres


public class action_timer extends TimerTask {
    
    private Timer timer;
    private boom explosion;
    private int j=0;
    
    public action_timer(Timer t, boom b) {
		explosion = b;
        timer = t;
    }
  
    public void run() {
        	if(j<6 && j>-1){
	
				explosion.set_imagei(j);
			}else{
				
				explosion.setVisible(false);
}
			j++;

}
    
    
    
}

