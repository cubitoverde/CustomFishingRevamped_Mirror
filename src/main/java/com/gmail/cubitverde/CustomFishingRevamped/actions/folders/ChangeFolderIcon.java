package com.gmail.cubitverde.CustomFishingRevamped.actions.folders;

import com.gmail.cubitverde.CustomFishingRevamped.actions.Action;
import com.gmail.cubitverde.CustomFishingRevamped.folders.Folder;
import org.bukkit.Material;

public class ChangeFolderIcon <T> implements Action {
    private Folder<T> folder;
    private Material material;

    public ChangeFolderIcon(Folder<T> folder, Material material) {
        this.folder = folder;
        this.material = material;
    }

    @Override
    public void run() {
        folder.setMaterial(material);
    }
}
