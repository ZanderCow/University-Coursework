package Maze_DS;

import DataStructures.EmptyCollectionException;
import asset.AbstractMouse;
import grid.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Mouse class for the MazeRunner application.
 * @author unknown
 */
public class Mouse extends AbstractMouse {

    private ArrayListStack<Location> crumbs;
    private Random rand;

    /**
     * Default Constructor of Mouse object.
     */
    public Mouse() {
        super();
        crumbs = new ArrayListStack<>();
        crumbs.push(this.getLocation());
        rand = new Random();
    }

    /**
     * Constructor used for the purposes of unit testing.
     * @param crmbs a previously existing stack of crumbs
     */
    public Mouse(ArrayListStack<Location> crmbs) {
        this.crumbs = crmbs;
        crumbs.push(this.getLocation());
    }

    /**
     * Determines which adjacent locations are empty for the mouse to traverse.
     *
     * @return a list of traversable empty locations
     */
    @Override
    protected List<Location> getEmptyLocations() {
        List<Location> emptyLocations = new ArrayList<>(4);

        // Create a list of locations adjacent to the mouse
        List<Location> adjacentLocations = getAdjacentLocations();

        // Examine each location adjacent to the mouse
        Location location;
        for (int i = 0; i < adjacentLocations.size(); i++) {
            location = adjacentLocations.get(i);

            // The location is valid if it can be traversed
            if (canTraverse(location)) {
                // If adjacent to cheese, go directly to it and find cheese
                if (seesCheeseAt(location)) {
                    moveTo(location);
                    foundCheese();
                    return emptyLocations;
                }

                /* Add the location to the empty locations list if it is not a 
                rock and has not been visited */
                if (!seesRockAt(location) && !hasVisited(location)) {
                    emptyLocations.add(location);
                }
            } else {
                /* Visited locations and rocks are considered invalid and 
                should be removed from the list of adjacent locations */
                adjacentLocations.remove(location);
            }
        }
        return emptyLocations;
    }

    /**
     * Controls the logic of how the mouse will move.
     * Check whether there are any empty locations to which the mouse
     * can move next.  The emptyLocations List passed into the method contains
     *  all the empty Locations adjacent to the mouse's current position. 
     *
     * @param emptyLocations a list of traversable empty locations
     */
    @Override
    public void move(List<Location> emptyLocations) {     

        // if there is a empty location
        if (!emptyLocations.isEmpty()){
            crumbs.push(this.getLocation()); // push the current location to the crumbs stack
            
            // move to a random location chosen from the emptyLocations List.
            int randomNum = rand.nextInt(emptyLocations.size());
            this.moveTo(emptyLocations.get(randomNum));
        }
        else{  // if theres not a empty location
            try{
                this.moveTo(crumbs.pop());  //pop the last Location visited 
            } catch (Exception e){
                
            }
        }
    }

    /**
     * Determines whether the mouse has already visited this location.
     *
     * @param location the location to check
     * @return true if the mouse has visited this location
     */
    @Override
    public boolean hasVisited(Location location) {
        boolean visited = false;
        try {
            Location l = crumbs.peek();
            if (l == location) {
                visited = true;
            }
        } catch (EmptyCollectionException e) {
            e.printStackTrace();
        }
        return visited;
    }

    /**
     * Instructs the mouse to move to the specified location.
     *
     * @param location the location to move to
     */
    @Override
    public void moveTo(Location location) {
        super.moveTo(location);
    }

    /**
     * Accessor method for crumbs field for the purposes of unit testing.
     *
     * @return the mouse's stack of crumbs
     */
    public ArrayListStack<Location> getCrumbs() {
        return crumbs;
    }

    /**
     * Generates a list of adjacent locations.
     *
     * @return the list of adjacent locations
     */
    @Override
    protected List<Location> getAdjacentLocations() {
        return super.getAdjacentLocations();
    }

    /**
     * Gets the current location of the mouse.
     *
     * @return the current location of the mouse
     */
    @Override
    public Location getLocation() {
        return super.getLocation();
    }

    /**
     * Checks whether the mouse can traverse a location.
     *
     * @param location the location to check
     * @return whether the mouse can traverse the location
     */
    @Override
    protected boolean canTraverse(Location location) {
        return super.canTraverse(location);
    }

    /**
     * Checks whether the mouse sees cheese at a location.
     *
     * @param location the location to check
     * @return whether the mouse sees cheese at the location
     */
    @Override
    protected boolean seesCheeseAt(Location location) {
        return super.seesCheeseAt(location);
    }

    /**
     * Checks whether the mouse sees a rock at a location.
     *
     * @param location the location to check
     * @return whether the mouse sees a rock at the location
     */
    @Override
    protected boolean seesRockAt(Location location) {
        return super.seesRockAt(location);
    }

    /**
     * Performed when cheese has been found by the mouse to complete the maze
     * run.
     */
    private void foundCheese() {
        super.setFoundCheese(true);
    }

}
