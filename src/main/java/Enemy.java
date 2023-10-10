 public class Enemy {
        private String enemyName;
        private Weapon enemyWeaponName;
        private int enemyhealth;

        public Enemy(String enemyName, Weapon enemyWeaponName, int enemyhealth){
            this.enemyName = enemyName;
            this.enemyWeaponName = enemyWeaponName;
            this.enemyhealth = enemyhealth;
        }

        public void enemyAttackPlayer(){
            // Hvor skal den kaldes henne? hvad får vi ind?
            // skal der her være en if for om health er <==0 ?
            if (enemyhealth >= 1){
                int attackResult;
            }
        }
        /* THE PLAYER ATTACKS ENEMY:
        public AttackMessage playerAttackEnemy(String currentEnemy){
        Enemy enemy = current.getEnemies().get(0);
        if (enemy == null) {
            return AttackMessage.NO_ENEMY_PRESENT;
        }
        if(currentWeapon != null){
            int attackResult = enemy.getEnemyhealth() - currentWeapon.getDamage();
            enemy.setEnemyhealth(attackResult);
           return currentWeapon.attack();
           // Enemys health - weapon damage
        }
        return AttackMessage.NO_WEAPON_EQUIPPED;
    }*/

     public String getEnemyName() {
         return enemyName;
     }

     public Weapon getEnemyWeaponName() {
         return enemyWeaponName;
     }

     public int getEnemyhealth() {
         return enemyhealth;
     }

     public void setEnemyhealth(int enemyhealth) {
         this.enemyhealth = enemyhealth;
     }

     public boolean isEnemyDead(Enemy enemy) {
            if (enemyhealth <= 0){
                //fjernes fra rummet
                //enemy weapon addes til rummet, evt. et lig?
                return true;
        } else {
                return false;
            }
    }

// Evt. abstract class? Så vi laver 2 forskellige sub-classes?

// Måske skal enemy være en nedarvet klasse til Player, da de har mange af de sammen funktioner og attributter

// Enemy skal indeholde et våben og en health bar og måske en parameter
// som afgør om de kan angribes med ranged weapon eller ej

// Enum tilføje scenarier i AttackMessage: PLAYER_DEAD, ENEMY_DEAD, PLAYER_WAS_DAMAGED,


// en funktion til at dræbe player og/eller enemy når man er løbet tør for health
}
