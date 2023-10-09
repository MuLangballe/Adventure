 public class Enemy {
        private String enemyName;
        private Weapon enemyWeaponName;
        private int enemyhealth;

        public Enemy(String enemyName, Weapon enemyWeaponName, int enemyhealth){
            this.enemyName = enemyName;
            this.enemyWeaponName = enemyWeaponName;
            this.enemyhealth = enemyhealth;
        }

        public boolean enemyIsDead(Enemy enemy) {
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
