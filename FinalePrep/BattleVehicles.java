public interface BattleVehicles {

    void showCardLvl();
    void updateHealth(int damage);
    
}

interface AirVehicles extends  BattleVehicles {

    
}


class Plane implements AirVehicles {
    int level, damage = 10, health = 15, advantageDamage = 15;

    String battleClass = "Air", subClass = "Plane";
    public void Plane(int level) {
        this.level = level;
    }

    public void updateHealth(int damage) {
        health -= damage;
    }

    public void showCardLvl() {

    }
}