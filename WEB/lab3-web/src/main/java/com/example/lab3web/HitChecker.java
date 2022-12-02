package com.example.lab3web;

public class HitChecker {

    public boolean isHit(int x, float y, float r) {
        if (x == 0 || y == 0)
            return -r/2 <= x && x <= r && -r/2 <= y && y <= r;
        if (x > 0 && y > 0)
            return r >= x && r >= y;
        if (x < 0 && y > 0)
            return false;
        if (x < 0 && y < 0)
            return r*r/4 >= x*x + y*y;
        if (x > 0 && y < 0)
            return y >= x - r/2;
        return false;
    }
}
