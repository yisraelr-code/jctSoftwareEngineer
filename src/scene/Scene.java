package scene;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometries;
import geometries.Intersectable;
import geometries.Triangle;
import primitives.Color;
import primitives.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;

/***
 * Scene class store all the scene components, including
 * Background color, ambient light, geometries objects, camera and
 * distance of the view plane from the Geometries objects.
 */
public class Scene {
    /***
     * name - scene name
     * background -  the background color
     * ambient light - the color on the specific object
     * geometries - the geometries objects represent on the scene
     * camera - details about the camera
     * distance - the distance from the camera to the objects
     */
    private String _name;
    private Color _background;
    private AmbientLight _ambientlight;
    private Geometries _geometries;
    private Camera _camera;
    private double _distance;
    private List<LightSource> _lights;
/*********   constructor   **********/

    /***
     * constructor for initialization
     * @param _name receive the scene name and initial it withe empty
     *              Geometries list
     */
    public Scene(String _name) {
        this._name = _name;
        this._geometries = new Geometries();
        this._lights = new LinkedList<LightSource>();
    }

/*********   Getter's    ********/

    /***
     *  name Getter
     * @return name of the scene
     */
    public String get_name() {
        return _name;
    }
    /***
     * background color Getter
     * @return background color
     */
    public Color get_background() {
        return new Color(_background);
    }
    /***
     * ambient light Getter
     * @return ambient light
     */
    public AmbientLight get_ambientlight() {
        return new AmbientLight(_ambientlight.get_intensity(),1.0);
    }
    /***
     * geometries Getter
     * @return the list fo all the Geometries on the scene
     */
    public Geometries get_geometries() {
        return _geometries;
    }
    /***
     * camera Getter
     * @return the camera components
     */
    public Camera get_camera() {
        return new Camera(_camera.getPlaceable(),_camera.getV_to(),_camera.getV_up());
    }
    /***
     * distance Getter
     * @return the distance between the view plane and geometries
     */
    public double get_distance() {
        return _distance;
    }

    /***
     * list of light sources getter
     * @return list of light sources
     */
    public List<LightSource> get_lights() {
        return _lights;
    }

/*********  functions  ***********/

    /***
     * function to update the background color
     * @param color the color of the background
     */
    public void setBackground(Color color){
        this._background = new Color(color);
    }
    /***
     * function to update the ambient light of the object
     * @param color ambient light color
     */
    public void setAmbientLight(AmbientLight color){
        this._ambientlight = new AmbientLight(color.get_intensity(), 1.0);
    }
    /***
     * function to update the camera details
     * @param param camera details
     */
    public void setCamera(Camera param){
        this._camera = new Camera(param.getPlaceable(), param.getV_to(), param.getV_up());
    }
    /***
     * function to update the distance from view plane to camera
     * @param dis the distance from view plane to camera
     */
    public void setDistance(double dis){
        this._distance = dis;
    }

    /***
     * function to add Geometries objects to the scene
     * receive list of Point3D and add them to the geometries list.
     * @param geometries Geometries objects
     */
    public void addGeometries(Intersectable... geometries){
        this._geometries.add(geometries);

    }

    /***
     * function to add light to the list of lights
     * @param lights a single element to add to the list
     */
    public void addLights(LightSource... lights){
        _lights.addAll(asList(lights));
    }
}
