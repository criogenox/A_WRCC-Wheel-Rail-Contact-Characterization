[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- PROJECT LOGO -->
<div align="center">
  <a align="center">
    <img src="https://user-images.githubusercontent.com/53323058/231350597-ae3f1833-2819-48bc-a582-9ab1341b847b.png" alt="Logo" width="800">
  </a>
  <h3 align="center">Railway applications &#x300A; A &#x300B;</h3>
  <p align="center">
    Wheel / Rail Contact Characterization Program
  </p>
</div>

<!-- MOTIVATIONS -->
## Global project's motivations

<div align="justify">
  <p>
Back in time, when I decided to enter in these unfamiliar waters, I would have appreciated to have access to more information and resources. Everything done was the product of sailing through a storm, on a old boat with only 1 oar. I learned from experience, but the learning path doesn't need to be like this. I'm not complaining about anything, I just pretend that if someone is interested in the information, they have access to help that I didn't have.
   </p>
 <p align="right">
    :muscle: don't let anyone get you down :muscle:
  </p> 
   <div>
     
<!-- ABOUT THE PROJECT -->
## About the project

<div align="justify">
This project was born as an aditional work to fullfil a personal pending asignature from my PhD days. Nothing more, nothing less. As the software name says: the program is capable of characterise the wheel-rail contact, useful in railway sector dynamics analyses. 
  
Let's Prof. Dr. Ing. habil. Oldrich Polach clarifies our way:

> In railway applications, the so-called equivalent conicity is used in order to characterise the contact geometry wheelset/track. Basically, the wheelset/track pairing is _“replaced”_ with an _“equivalent wheelset”_ having a conical wheel tread surface, which only possesses validity for a specific wheelset lateral amplitude. The equivalent conicity is then the conicity of a conical wheelset performing a similar wavelike motion as the examined wheelset, at the prescribed lateral amplitude.
  
The equivalent conicity acts as a safety parameter which describes the behavior and dynamic interaction between rails & wheels running on a straight or large radius (curved) track. This way, the equivalent conicity could indicate the presence of instable movement leading to a derailment event, therefore It can be used to determine a critical speed of a train at any type of track.
  
This crucial parameter could be calculated based on two standards, namely **UIC 519** and **EN 15302**. The non-linear method described in the last one is used by the given software (see the benchmark program in Railway applications 《 B 》- Equivalent Conicity Calculation).


For the described method of determination the following assumptions are used:
 in the calculation both the wheel and the rail are considered rigid;
 wheels are symmetrical in revolution and are represented by a single profile for each wheel;
 rails are straight, parallel to each other and represented by a single profile for each rail;
 wheel does not penetrate into the rail: only point contacts are considered; 

This is done by the following procedure:
a) determine the wheel and rail profiles, either by measurement of real profiles or by a theoretical calculation
for theoretical profiles;
b) determine the ∆r = f(y) characteristic giving, for each lateral movement y of the wheelset on the track, the
difference between the right-hand and the left-hand rolling radius ∆r = r1 – r2;
c) determine the equivalent conicity for a lateral movement yˆ of the wheelset on the track. 

 
  Reference profiles in Annex D must be smoothed by interpolation, which allows the location of the contact points in order to calculate the rolling radius difference as a function of the lateral position of the wheelset.
  Starting from this function the equivalent conicity is calculated as a function of the amplitude of the oscillation. 
  
* The reference profiles used, whose are defined for benchmark calculations in the Annex D to test the algorithm in a wide range of conditions, have been smoothed by cubic interpolation which allows the location of the contact points in order to calculate the rolling radius difference as a function of the lateral position of the wheelset. 
  
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With

<div style="display: flex; flex-direction: row; align=center">
  <a href="https://openjfx.io/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230740541-3d3ee950-7f4c-4399-9275-9795ea7c4f37.png" alt="Logo" width="160" height="65"/>
  </a>
  <a href="https://www.w3.org/TR/CSS/#css">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230694275-351e4257-7cbf-4dc7-a1b6-42079b9b37aa.png" alt="Logo" width="160" height="65"/>
  </a>
  <a href="https://netbeans.apache.org/">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230740868-4ac4dc6c-dc63-494b-8817-01ce016d8347.png" alt="Logo" width="160" height="65"/>
  </a>
  
### Additional info

* Manual GUI design & implementation. No fxml file is used in this project (SceneBuilder). Good practice to really understand what you actually are doing.
  
* No Maven artifacts are used (required libraries are enclosed in lib folder). JavaFX library must be properly configured in your IDE to run the program (minimum requirement = SDK v19).
  
* For a more in-depth understanding of the implemented equations, formulas, and algorithms, as many comments as possible have been included.
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- SUMMARY -->
## Background & Details

<div align="justify"> 
  <!-- <img align="right" src="https://user-images.githubusercontent.com/53323058/230650942-4c2e0ad4-2d52-46fe-aa67-8860c642e5f6.png" width="500"> -->
<img align="right" src="https://user-images.githubusercontent.com/53323058/230650942-4c2e0ad4-2d52-46fe-aa67-8860c642e5f6.png" width="500">

### Introduction
  
Both the theoretical and the real profiles (including worn ones) cannot be described by a linear function as in the case of wheels with a conical profile, therefore, the difference between the rolling radii of each wheel for different values of lateral displacement brings a nonlinear function ∆r. To linearize this function, the concept of equivalent conicity originally defined by the UIC 519 standard (EN 15302) is used, approximating the relationship between ∆r and the amplitude of the lateral displacement.

For a wheel with a conical profile, the equivalent conicity is simply the half-angle of the tread of the cone. For wheels with arbitrary profiles, the equivalent conicity is defined as the tangent of the angle of the cone of a purely conical profile whose lateral movement produces a kinematic oscillation with the same wavelength as the pair mounted with arbitrary profiles. This definition is only applicable in the analysis on straight paths and large radius curves (Rc ≥ 2500m).

In this way, the equivalent conicity is a parameter used to characterize the geometry of the wheel-rail contact and establishes the criterion for assessing the influence of the contact on the vehicle's driving stability on a straight track. 

<img align="right" width="500" src="https://user-images.githubusercontent.com/53323058/230651059-2a746e31-8ca0-42a1-9418-eb15def72d44.png">

### Wheel's taper conicity importance
  
The value of the wheel conicity provides quantitative information on the influence of the wheel-rail interaction on the quality of ride comfort and the dynamic stability of the rail vehicle.
  
High taper conicity (shortest wavelength at comparative constant speed):
  * Increase the compensating effect on the centrifugal force generated on curved paths, reducing the risk of derailment.
  * Reduce driving comfort on a straight track due to the presence of greater lateral accelerations.
  
Low taper conicity (longer wavelength at comparative constant speed):
  * Increase the frequency of occurrence of the flange hit during circulation in slight curves, causing excessive wear on the wheel profile.
  * Decrease the lateral acceleration, increasing ride quality on straight paths.

### Summary of the numerical estimation of equivalent conicity
  
The method proposed by the EN 15302 standard is based on the analysis of the kinetic movement of a pair mounted on a straight track or large radius curved paths. The determination of the equivalent conicity is performed by numerically integrating of the ∆r function, representing the longitudinal distance traveled in terms of lateral displacement, x = f(y). From the latter, the wavelength λ is obtained for a lateral displacements in the interval [1-7 mm] with increments of ∆y ≤ 0.1mm, to finally determine the equivalent conicity by using the Klingel's formula for a conical profile whose kinematic movement presents the same wavelength.
  
<img align="right" width="500" src="https://user-images.githubusercontent.com/53323058/230651010-9eef1df9-c020-47aa-b1ca-87671a28effe.png">
 
The software capabilities focuses on the characterization of wheel-rail rigid contact through the aid of following specific calculations:

* Potential wheel-rail contact points detection by mean of rigid profiles penetration comparision.
* tan(γa) --> angle of the tangent to the point of contact between wheel and rail.
* ∆r --> rolling-radius difference function, at the predefined lateral amplitude interval. 
* tan(γc)=f(λ) --> Determination of the equivalent conicity for each movement wavelength of an (equivalente) conical profile, at a specific lateral displacement (wave amplitude).
  
The included parameters that influence the determination of the equivalent conicity are the geometry of the profiles, the gauge of the track, the inclination of the rail and the active gauge of the mounted pair. Other factors, not implemented up to the present time, that increase the complexity of the process calculation are the wear of the profiles and the deviations present in the track layout, such as the unevenness, gauge difference and alignment. 

From the processed conicity value, the stability of the vehicle can be evaluated depending on longitudinal running velocity, ensuring the generation of the required restoring forces when the formation goes through a open curve, increasing safety against derailment. Nevertheless, for real profiles and after a long period of use, the equivalent taper conicity can be reach values in a higher range due to excessive wear, and must be critically evaluated by a trained professional.       
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

- [x] Improve potential contact points detection 
- [x] Asymetric cases implementation
- [x] Stand-alone unified version (Equivalent conicity add-on)
- [x] Implementation of output options (PDFBox library)     
- [x] Improve error events handling
- [ ] Increse profiles data base (APTA/ARR standards & worn cases)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://user-images.githubusercontent.com/53323058/230575198-fa1acbf4-8f82-4d8e-b245-3979276bc240.png
[linkedin-url]: https://www.linkedin.com/in/vincent-tnecniv/
