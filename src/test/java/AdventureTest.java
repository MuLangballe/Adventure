import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

    Map map;
    Player player;

    @BeforeEach
    public void setUp() {
        map = new Map();
        map.buildMap();
        player = new Player(100);
        player.setCurrentRoom(map.getStartRoom());
    }


    @Test
    public void Enemy_Attack_Player_Test() {

        // Act
        player.enemyAttackPlayer(player);

        // Assert

        assertEquals(50, player.getHealthPoints());

    }

    @Test
    public void moveToNextRoom_Go_East() {
        // Arrange


        // Act


        // Assert
    }

/*    @Test
    public void is_monster_present(){
        //Arrange
        Room testRoom = new Room ("test Room", "test rum beskrivelse");
        testRoom.addEnemy(new Enemy("Testmonster", new MeleeWeapon("Testvåben", "Test", EatMessage.CANT_EAT, EquipMessage.EQUIP, 50), 50));

        //Act
        testRoom.

        //Assert

    }

*/
}