package com.common.photo.models.puzzle.template.slant;

import com.common.photo.models.puzzle.PuzzleLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wupanjie
 */
public class SlantLayoutHelper {
    private SlantLayoutHelper() {

    }

    public static List<PuzzleLayout> getAllThemeLayout(int pieceCount) {
        List<PuzzleLayout> puzzleLayouts = new ArrayList<>();
        switch (pieceCount) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    puzzleLayouts.add(new OneSlantLayout(i));
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    puzzleLayouts.add(new TwoSlantLayout(i));
                }
                break;
            case 3:
                for (int i = 0; i < 6; i++) {
                    puzzleLayouts.add(new ThreeSlantLayout(i));
                }
                break;
        }

        return puzzleLayouts;
    }
}
