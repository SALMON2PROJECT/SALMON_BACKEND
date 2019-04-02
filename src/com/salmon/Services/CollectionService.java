package com.salmon.Services;

import com.salmon.TO.MetadataCollection;
import com.salmon.TO.PdfCoreCollection;
import dkproparent.compare.Compare;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.rmi.Naming;
import java.util.List;

/**
 * Collector Agent
 */
@Repository
@Transactional
public class CollectionService {
    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) throws Exception {
        String tags = "Physical sciences,General relativity,Galaxies,BBH,Science,Binary black hole,Astronomical objects,Gravitational waves,Binary stars,Natural sciences,";
        //String tags = ".sosis.sosis.Asena.Badakhlagh:/)";
        // String text = "ar X iv :     v  [ as tr o- ph G A ]  M ar    Supermassive black holes and dark halo from the Bose-condensed dark matter M Morikawa and S Takahashi March   Department of Physics Ochanomizu University -- Otsuka Bunkyo Tokyo - Japan Abstract Most of the galaxies harbor supermassive Black Holes (SMBH) in their center Some of them are observed in very high redshifts We explore the possibility that SMBH form from the coherent waves of Bose-Einstein condensate (BEC) which are supposed to form the dark matter We first study the isotropic and anisotropic collapses of BEC We find the BEC wave can easily collapse to form SMBH but the realistic amount of angu- lar momentum completely prevents the collapse We further explore the Axion case with attractive interaction and find the moderate mass ratio between the SMBH and the dark halo around it We also obtain the mass distribution function of BH within a single galaxy  Introduction Supermassive black holes (SMBH) of mass ?M?are observed in the most of the galaxies[kormendy] All of them are located in the galactic center and not a small amount of SMBHs are already formed very early in the cosmic history of redshift z ?  ?  [Banados ] Moreover masses of the SMBH have strong correlation with the velocity dispersion ? of the galactic bulge MBH ? ? [kormendy] All of these properties strongly indicate that the SMBH plays the central role in the galaxy history and even defines the center of the galaxy[Morikawa ] Then the principal question would be the origin of these SMBH Individual questions related to the SMBH formation will be  (universality in the Universe) Why most of the galaxies harbor SMBH of huge size?M??  (location in the galaxy) Why all the SMBH is located at the center of the galaxy?   (causal relation with galaxy) Why SMBH form so early at least as z ? ?  ?  (correlation with galaxy) Why SMBH is firmly correlated with the galaxy bulge MBHï¿½ ? ??  (correlation with dark halo (DH)) Why SMBH mass is correlated with the galaxy dark halo mass MDH as MBHï¿½ ? ?MDH? There have been many literature in the past trying to answer these questions Most of them have been generally summarized in the diagram in [Rees ] Basic mechanism in these is the gas collapse to form the primordial black holes (BH) followed by the coalescence of them or the accretion of the gas on them Relatively heavy BH is expected from the early population stars of mass ?M? [Volonteri] The gas heating tends to prevent the effec- tive accretion If a huge gas clump directly collapses to form a black hole of size ?M?[Oh] then the Eddington accretion rate can explain the early formation of SMBH although some tuning of parameters is needed All of these theories assume that the SMBHs are formed by baryons or fermions Contrary to them we now would like to explore another possibility that the SMBHs are formed by the dark matter (DM) or bosons in particular by the quantum condensed boson fields such as the Bose-Einstein condensa- tion (BEC) The quantum condensation of bosons behaves very differently from fermions or from the fermion condensations and forms the macroscopic co- herent wave If the DM is formed from light bosons then it can easily form the quantum condensates which may coherently collapse to form SMBH in the early stage[Nishiyama ] Then the stars and their clusters are formed around these SMBH afterward All the above individual questions naturally suggest that the SMBH defines the center of the galaxy first SMBH can be formed before stars and galax- ies even at z ?  ?  and the SMBH may trigger the subsequent star and galaxy formation at later time z ?  In other words the co-evolution might be very rapid in the early stage and the galaxy merger would not be the dom- inant mechanism at the SMBH formation stage[Heckman] We now focus on the first stage of this scenario i e the early formation of SMBH The subse- quent star and galaxy evolution will be discussed in separate articles extending [Morikawa ] and including observational predictions Thus we explore in this paper the possibility of the collapse of the coher- ent boson field which may be the main component of the dark matter (DM) [Fukuyama ] Our problem is now extended to the question of how SMBH and dark halo (DH) being two different forms of DM are separated from each other? In the next section  we clarify how the BEC DM is possible and how the condensation evolves in the Universe In section  we explore the collapsing dynamics in various conditions and show the BEC DM actually collapses to form SMBH/DH In section  we consider the Axion model for BEC-DM and try to derive the time and mass scales of the SMBH In the last section   we conclude our study and describe the subsequent scenario for the galaxy formation triggered by the SMBH  How do SMBHs form? We Physical sciences Velocity dispersion SMBH Dark matter Physical cosmology Supermassive black holes Galaxies Celestial mechanics Natural sciences Astronomy  Physical sciences Velocity dispersion SMBH Dark matter Physical cosmology Supermassive black holes Galaxies Celestial mechanics Natural sciences Astronomy ";
        String text = ("X\n" +
                "iv\n" +
                ":1\n" +
                "81\n" +
                "1.\n" +
                "00\n" +
                "00\n" +
                "8v\n" +
                "1 \n" +
                "[\n" +
                "as\n" +
                "tr\n" +
                "o-\n" +
                "ph\n" +
                ".G\n" +
                "A\n" +
                "] \n" +
                "3\n" +
                "1 \n" +
                "O\n" +
                "ct\n" +
                "2\n" +
                "01\n" +
                "8\n" +
                "Astronomy in Focus\n" +
                "XXXth IAU General Assembly, August 2018\n" +
                "Teresa Lago, ed.\n" +
                "cï¿½ 2018 International Astronomical Union\n" +
                "DOI: 00.0000/X000000000000000X\n" +
                "Magnetic field constraint in the outskirts of\n" +
                "spiral galaxies\n" +
                "Ericson Lopez1,2 Jairo Armijos1 Mario Llerena1 Franklin Aldaz1\n" +
                "1Quito Astronomical Observatory, National Polytechnic School,\n" +
                "Box 17-01-165 Quito, Ecuador\n" +
                "email: ericsson.lopez@epn.edu.ec\n" +
                "2Physics Department, Sciences Faculty, National Polytechnic School,\n" +
                "Box 17-01-2759 Quito, Ecuador\n" +
                "Abstract. Based on CO(2-1) public data, we study the monoxide oxygen gas excitation con-\n" +
                "ditions and the magnetic field strength of NGC 2841, NGC 3077, NGC 3184, NGC 3351 spiral\n" +
                "galaxies. For their galaxy outskirts, we found kinetic temperatures in the range of 35?38 K, CO\n" +
                "column densities 1015 ? 1016 cm?2 and H2 masses of 4 106 ? 6 108M?. An H2 density 10\n" +
                "3cm?3\n" +
                "is suitable to explain the 2 sigma upper limits of the CO(2-1) line intensity. We constrain the\n" +
                "magnetic field strength for our sample of spiral galaxies and their outskirts, evaluating a sim-\n" +
                "plified expression of the magneto-hydrodynamic force equation. Our estimations provide values\n" +
                "for the magnetic field strength in the order of 6? 31 ï¿½G.\n" +
                "Keywords. galaxies: halos, galaxies: magnetic fields, galaxies: spiral.\n" +
                "1. Introduction\n" +
                "In this work, we study the magnetic field strength in the outskirts of four spiral galaxies:\n" +
                "NGC 2841, NGC 3077, NGC 3184, NGC 3351, following a different approach to those\n" +
                "commonly based on Faraday rotation, dust polarization, synchrotron emission, and so\n" +
                "on. To constrain the magnetic field strength of spiral galaxies we will follow the Dotson\n" +
                "method (Dotson 1996), i.e., approaching the magneto-hydrodynamic force equation to\n" +
                "derive a simple expression that let us to estimate the upper limit of the magnetic field.\n" +
                "On the other hand, to estimate the density n and mass M of the sources, we use the\n" +
                "carbon monoxide emission as a tracer for the molecular gas H2 (Neininger et al. 1998).");//.split(" ")


//        System.out.println("==================================== Filter for tags ===== ");
//
//        System.out.println("Tags " + tags);
//        tags = tags.replaceAll(" ", "");
////        tags = tags.replaceAll(",", " ");
////        System.out.println("Tags" + tags);
//        tags = tags.replaceAll("  ", " ");
//        tags = tags.replaceAll("\\.", " ");
//        System.out.println("Tags " + tags);
////        System.out.println("text" + text);
//
//        System.out.println("==================================== Filter for text =====");
//
//        text = text.replaceAll("\\s+", " ");
//        text = text.replaceAll(",", " ");
////        System.out.println("text" + text);
////        text = text.replaceAll("  ", " ");
////        System.out.println("text" + text);
//        text = text.replaceAll("   ", " ");
//        text = text.replaceAll("\\d", "");
////        System.out.println("text" + text);
////        text = text.replaceAll("[^\\x00-\\x7F]", "");
////        text = text.replaceAll("[\u0000-\u001f]", "");
////        text = text.replace("?", "\0");   /// EROR  herer is the problem
////        text = text.replaceAll("- ", "");
//        text = text.replaceAll("\\d", "");
//        text = text.replaceAll("   ", " ");
//        //  text = text.replaceAll("    ", " ");
//        text = text.replaceAll("     ", " ");
////        text = text.replaceAll("   ", " ");
////        text = text.replaceAll("  ", " ");
//        System.out.println("text" + text);
////        text = text.replace(". .", ".");
////        text = text.replaceAll("\\d", "");
////        text = text.replaceAll("  ", " ");
//        System.out.println("text final : " + text);
//
//        System.out.println("==================================== Filter for Combination of tags and text =====");
//        text = text + tags;
//        System.out.println("text final " + text);
//        //text = isNormalized("" , sosis);
        text = text
                .replaceAll(";", "")
                .replaceAll("[\u0000-\u001f]", " ").replaceAll("[^\\x00-\\x7F]", " ")
                .replaceAll(",", " ")
                .replaceAll("\\(", "").replaceAll("\\)", " ").replaceAll("\\d", " ")
                .replaceAll("\\?", "").replaceAll("\\<", " ").replaceAll("\\>", " ")
                .replaceAll("- ", "").replaceAll("\\/", " ").replaceAll("\\=", " ")
                .replaceAll("\\:", " ").replaceAll("\\[", " ").replaceAll("\\]", " ")
                .replace(".", " ").replaceAll(",", " ").replaceAll("     ", "")
                .replace("  ", " ").replace("  ", "");

        System.out.println("text final " + text);
    }

    public List<MetadataCollection> getAll() {
        try {

            return entityManager.createQuery("select entity from metaData entity").getResultList();

        } catch (Exception e) {
            return null;
        }

    }

    public boolean getMetaData() {

        try {

            List list = entityManager.createQuery("select entity from metaData entity").getResultList();
            if (list.size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }


    }

    public void collection(String text, String semanticTags, String title, String url) {
        try {
            Compare compare = (Compare) Naming.lookup("//localhost/compare");

            /**
             FILTER TEXT OF PDF-CORE
             */
            System.out.println("==================================== Filter for text =====");

            text = text
                    .replaceAll(";", "")
                    .replaceAll("[\u0000-\u001f]", " ").replaceAll("[^\\x00-\\x7F]", " ")
                    .replaceAll(",", " ")
                    .replaceAll("\\(", "").replaceAll("\\)", " ").replaceAll("\\d", " ")
                    .replaceAll("\\?", "").replaceAll("\\<", " ").replaceAll("\\>", " ")
                    .replaceAll("- ", "").replaceAll("\\/", " ").replaceAll("\\=", " ")
                    .replaceAll("\\:", " ").replaceAll("\\[", " ").replaceAll("\\]", " ")
                    .replace(".", " ").replaceAll(",", " ").replaceAll("     ", "")
                    .replace("  ", " ").replace("  ", "");
            /**
             FILTER for tags
             */

            //semanticTags = semanticTags.replaceAll(" ", "");
            // semanticTags = semanticTags.replaceAll(",", " ");
            //System.out.println("Tags" + semanticTags);
            //semanticTags = semanticTags.replaceAll("  ", " ");
            //semanticTags = semanticTags.replaceAll("\\.", " ");
            //System.out.println("Tags" + semanticTags);
//          System.out.println("text" + text);
            text = text + semanticTags;
//            System.out.println("==================================== t e x t  +  S e m a n t i c T a g s  ");
            /*text = text.replaceAll(",", " ");
            text = text.replaceAll("  ", " ");*/
            System.out.println("====================FINAL================ t e x t  +  S e m a n t i c T a g s + Filtering ");
            System.out.println(text);
            List<MetadataCollection> metadataCollectionList = getAll();

            MetadataCollection collection = new MetadataCollection();
            //String content=text.replaceAll("\\n"," ");

            /**
             FILTER TEXT OF Metadata
             */


            if (getMetaData()) {
                for (MetadataCollection metadataCollection : metadataCollectionList) {

                    String specMeta = getSpecMetaData(url);
                    /**
                     * these tags come from database
                     * dbl = threshhold
                     */
                    String semantictagDB = metadataCollection.getSemanticTags().replaceAll(",", " ");
                    String metaDataDB = metadataCollection.getMetaData();
                    metaDataDB = metaDataDB + semantictagDB;
                    metaDataDB = metaDataDB.replaceAll("  ", "");
                    Double dbl = compare.compareMethod(text.split(" "), metaDataDB.split(" "));
                    // System.out.println("metaDataDB : " + metaDataDB + "this is the end of text");
                    System.out.println("text for current pdf-core :" + text + "this is the end of text");
                    System.out.println("Similarity is  :::::::::::::::::::::" + dbl + " Link of added pdf core  : " + url + " with parent collection :" + metadataCollection.getPdfCore());
                    if (dbl > 75 & specMeta.equals("false")) {
                        PdfCoreCollection pdfCoreCollection = new PdfCoreCollection();
                        updateSemanticTags(semanticTags, metadataCollection.getId());
                        pdfCoreCollection.setScore(0);
                        pdfCoreCollection.setPdfCoreMetaData(text);
                        pdfCoreCollection.setRelevant(true);
                        pdfCoreCollection.setPdfCore(url);
                        pdfCoreCollection.setTitle(title);
                        System.out.println("MainTitle is:::::::" + title);
                        pdfCoreCollection.setPercentage(dbl);
                        pdfCoreCollection.setMetadataCollection(metadataCollection);
                        entityManager.persist(pdfCoreCollection);
                    }
                }
            }
            String specPdfCore = getSpecPdfCore(url);
            String specMeta = getSpecMetaData(url);
            if (!getMetaData() || (specMeta.equals("false") & specPdfCore.equals("false"))) {
                PdfCoreCollection pdfCoreCollection = new PdfCoreCollection();
                pdfCoreCollection.setPdfCore(url);
                pdfCoreCollection.setTitle(title);
                pdfCoreCollection.setRelevant(true);
                pdfCoreCollection.setScore(0);
                pdfCoreCollection.setPercentage(100);
                collection.setMetaData(text);
                collection.setPdfCore(url);
                collection.setTitle(title);
                collection.setSemanticTags(semanticTags);
                pdfCoreCollection.setMetadataCollection(collection);
                entityManager.persist(collection);
                entityManager.persist(pdfCoreCollection);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("collection has an exception");
        }
    }

    public String getSpecMetaData(String url) {
        try {


            entityManager.createQuery("select entity from metaData entity where entity.pdfCore=:x ").setParameter("x", url).getSingleResult();


            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

    public List<PdfCoreCollection> getCollections() {
        try {
            List list = entityManager.createQuery("select entity from PdfCoreCollection entity").getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }

    }

    public String getSpecPdfCore(String url) {
        try {
            List<PdfCoreCollection> list = entityManager.createQuery("select entity from PdfCoreCollection entity where entity.pdfCore=:x ")
                    .setParameter("x", url).getResultList();
            if (list.isEmpty()) {
                return "false";
            }

            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

    public void updateSemanticTags(String tags, long id) {

        entityManager.createQuery("update metaData o set o.semanticTags=:x||o.semanticTags  where o.id=:u")
                .setParameter("x", tags).setParameter("u", id).executeUpdate();

    }


}