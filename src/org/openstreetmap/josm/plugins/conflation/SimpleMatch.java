// License: GPL. See LICENSE file for details. Copyright 2012 by Josh Doe and others.
package org.openstreetmap.josm.plugins.conflation;

import org.openstreetmap.josm.data.osm.OsmPrimitive;
import static org.openstreetmap.josm.tools.I18n.tr;

/**
 * This class represents a potential match, i.e. a pair of primitives, a score
 * and related information.
 */
public class SimpleMatch {

    OsmPrimitive referenceObject;
    OsmPrimitive subjectObject;
    double score;
    double distance;

    public SimpleMatch(OsmPrimitive referenceObject,
            OsmPrimitive subjectObject, double score) {
        if (referenceObject == null || subjectObject == null) {
            throw new IllegalArgumentException(tr("Invalid reference or subject"));
        }
        this.referenceObject = referenceObject;
        this.subjectObject = subjectObject;
        this.score = score;
        // TODO: use distance calculated in score function, and make sure it's in meters?
        this.distance = ConflationUtils.getCenter(referenceObject).distance(ConflationUtils.getCenter(subjectObject));
    }

    public OsmPrimitive getReferenceObject() {
        return referenceObject;
    }

    public OsmPrimitive getSubjectObject() {
        return subjectObject;
    }

    public Object getScore() {
        return score;
    }

    public Object getDistance() {
        return distance;
    }
}