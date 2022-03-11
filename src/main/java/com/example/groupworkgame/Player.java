package com.example.groupworkgame;

public class Player {
    public boolean up, isDead;
    public float velY, rotY;

    public Player(boolean up, int velY, int rotY, boolean isDead) {
        this.up = up;
        this.velY = velY;
        this.rotY = rotY;
        this.isDead = isDead;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getRotY() {
        return rotY;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }
}
