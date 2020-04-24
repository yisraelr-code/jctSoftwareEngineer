package unittests;
import org.junit.*;
import geometries.Geometries;
import geometries.Plane;
import geometries.Sphere;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.lang.reflect.Array;
import java.util.*;

public class GeometriesTests {

    /***
     * Test method for {@link geometries.Geometries#findIntsersections(Ray)}
     */
    @Test
    void testfindIntsersections(Ray ray) {

        // ============ Equivalence Partitions Tests ==============

        //three object and the Ray has only two intersection.
        Sphere sphere = new Sphere(new Point3D(1,1,1), 0.5);
        Ray test_ray = new Ray(new Point3D(0.8,0.8,0.8),new Vector(new Point3D(1,0,0)));
        Plane plane = new Plane(new Point3D(1,1,2), new Vector(-1,-1,1));
        Plane plane2 = new Plane(new Point3D(2,0.5,0.5), new Vector(1,-2,-2));

        ArrayList<Point3D> points = new ArrayList<Point3D>();
        points.addAll(sphere.findIntsersections(test_ray));
        points.addAll(plane.findIntsersections(test_ray));
        points.addAll(plane2.findIntsersections(test_ray));

        Geometries geometries = null;
        geometries.add(sphere);
        geometries.add(plane);
        geometries.add(plane2);

        assertEquals("not all intersections found",geometries.findIntsersections(test_ray), points);

        // =============== Boundary Values Tests ==================

        // an empty list, not contain any Geometries object
        assertEquals("empty list of objects",new Geometries().findIntsersections(test_ray), null);

        // not empty list, but no intersections at hole
        Ray test_ray2 = new Ray(new Point3D(0,1,0), new Vector(new Point3D(1,2,2)));
        points.clear();
        points.addAll(sphere.findIntsersections(test_ray2));
        points.addAll(plane.findIntsersections(test_ray2));
        points.addAll(plane2.findIntsersections(test_ray2));

        assertEquals("the Ray don't has intersections with the objects",geometries.findIntsersections(test_ray2),points);

        // one Geometry object is intersect with the Ray
        points.clear();
        points.addAll(sphere.findIntsersections(test_ray));
        points.addAll(plane.findIntsersections(test_ray));

        geometries = null;
        geometries.add(sphere);
        geometries.add(plane);

        assertEquals("only one object is intersected with the Ray", geometries.findIntsersections(test_ray),points);

        // all object is intersected with the Ray
        Ray test_ray3 = new Ray(new Point3D(0.8,0.8,0.8), new Vector(new Point3D(-0.5,-1,-1)));

        geometries.add(plane2);

        points.clear();
        points.addAll(sphere.findIntsersections(test_ray3));
        points.addAll(plane.findIntsersections(test_ray3));
        points.addAll(plane2.findIntsersections(test_ray3));

        assertEquals("all Geometries objects intersected with the ray", geometries.findIntsersections(test_ray3),points);

    }

}