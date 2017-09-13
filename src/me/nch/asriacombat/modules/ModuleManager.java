package me.nch.asriacombat.modules;

import java.util.ArrayList;

public class ModuleManager {
    private static ModuleManager ourInstance = new ModuleManager();

    public static ModuleManager getInstance() {
        return ourInstance;
    }

    private ModuleManager() {
        this.modules = new ArrayList<>();
    }

    private ArrayList<Module> modules;

    public void registerModules() {
        modules.add(new SprintingModule());
        modules.add(new JumpingModule());
        modules.add(new BracingModule());

        modules.add(new LocationCheckModule());
        modules.add(new CrouchWalkingModule());
        //TODO Register modules.
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

}
