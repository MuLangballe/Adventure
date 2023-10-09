import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventureTest {

    @Test
    public void moveToNextRoom_Go_East() {
        // Arrange


        // Act


        // Assert
    }

    @Test
    public void is_monster_present(){
        //Arrange
        Room testRoom = new Room ("test Room", "test rum beskrivelse");
        testRoom.addEnemy(new Enemy("Testmonster", new MeleeWeapon("Testvåben", "Test", EatMessage.CANT_EAT, EquipMessage.EQUIP, 50), 50));

        //Act
        testRoom.

        //Assert

    }


}