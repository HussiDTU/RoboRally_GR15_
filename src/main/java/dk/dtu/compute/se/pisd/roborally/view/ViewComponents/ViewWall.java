package dk.dtu.compute.se.pisd.roborally.view.ViewComponents;

import dk.dtu.compute.se.pisd.roborally.controller.FieldAction;
import dk.dtu.compute.se.pisd.roborally.model.Heading;
import dk.dtu.compute.se.pisd.roborally.model.Space;
import dk.dtu.compute.se.pisd.roborally.model.SpaceComponents.Gear;
import dk.dtu.compute.se.pisd.roborally.view.SpaceView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.List;

public class ViewWall {

    public static void drawWall(SpaceView spaceView, Space space) {

        List<Heading> walls = space.getWalls();
        Canvas canvas = new Canvas(SpaceView.SPACE_WIDTH, SpaceView.SPACE_HEIGHT);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image verticalWall = new Image("Images/VerticalWall.png", 60, 60, true, true);
        Image horizontalWall = new Image("Images/HorizontalWall.png", 60, 60, true, true);

        for (Heading heading : walls) {
            switch (heading) {
                case EAST -> gc.drawImage(horizontalWall, 44, 0);
                case WEST -> gc.drawImage(horizontalWall, 0, 0);
                case SOUTH -> gc.drawImage(verticalWall, 0, 44);
                case NORTH -> gc.drawImage(verticalWall, 0, 0);
            }
        }
        spaceView.getChildren().add(canvas);
    }
}