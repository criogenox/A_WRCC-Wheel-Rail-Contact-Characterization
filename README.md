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
Back in time, when I decided to enter these unfamiliar waters, I would have appreciated having access to more information and resources. Everything done was the product of sailing through a storm, on a old boat with only 1 oar. I learned from experience, but the learning path doesn't need to be like this. I'm not complaining about anything, I just pretend that if someone is interested in the information, they have access to help that I didn't have.
   </p>
 <p align="right">
    :muscle: don't let anyone get you down :muscle:
  </p> 
   <div>
     
<!-- ABOUT THE PROJECT -->
## About the project

<div align="justify">
This project was born as an additional work to fulfil a personal pending signature from my PhD days. Nothing more, nothing less. As the software name says: the program is capable of characterizing the wheel-rail contact, useful in railway sector dynamics analyses. 
  
Let's Prof. Dr. Ing. habil. Oldrich Polach clarifies our way:

> In railway applications, the so-called equivalent conicity is used in order to characterise the contact geometry wheelset/track. Basically, the wheelset/track pairing is _“replaced”_ with an _“equivalent wheelset”_ having a conical wheel tread surface, which only possesses validity for a specific wheelset lateral amplitude. The equivalent conicity is then the conicity of a conical wheelset performing a similar wavelike motion as the examined wheelset, at the prescribed lateral amplitude.
  
The equivalent conicity acts as a safety parameter which describes the behavior and dynamic interaction between rails & wheels running on a straight or large radius (curved) track. This way, the equivalent conicity could indicate the presence of instable movement leading to a derailment event; therefore, It can be used to determine a critical speed of a train at any type of track.
  
This crucial parameter could be calculated based on two standards, namely **UIC 519** and **EN 15302**. The non-linear method described in the last one is used by the given software (see the benchmark program in Railway applications 《 B 》- Equivalent Conicity Calculation).
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With

<div style="display: flex; flex-direction: row; align=center">
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230740541-3d3ee950-7f4c-4399-9275-9795ea7c4f37.png" alt="Logo" width="160" height="65"/>
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230694275-351e4257-7cbf-4dc7-a1b6-42079b9b37aa.png" alt="Logo" width="160" height="65"/>
    <img class="img"src="https://user-images.githubusercontent.com/53323058/230740868-4ac4dc6c-dc63-494b-8817-01ce016d8347.png" alt="Logo" width="160" height="65"/>

### Additional info

* Manual GUI design & implementation. No fxml file is used in this project (SceneBuilder). Good practice to really understand what you actually are doing.
  
* No Maven artifacts are used (required libraries are enclosed in lib folder). JavaFX's library must be properly configured in your IDE to run the program (minimum requirement = SDK v19).
  
* For a more in-depth understanding of the implemented equations, formulas, and algorithms, as many comments as possible have been included.
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- SUMMARY -->
## Background & Details

<div align="justify"> 
  <!-- <img align="right" src="https://user-images.githubusercontent.com/53323058/230650942-4c2e0ad4-2d52-46fe-aa67-8860c642e5f6.png" width="500"> -->
<img align="right" src="https://user-images.githubusercontent.com/53323058/243650479-1608aebd-71a4-4c0f-8ddc-44b7cb7486aa.png" width="500">

### Introduction
  
Both the theoretical and the real profiles (including worn ones) cannot be described by a linear function as in the case of wheels with a conical profile, therefore, the difference between the rolling radii of each wheel for different values of lateral displacement brings a nonlinear function ∆r. To linearize this function, the concept of equivalent conicity originally defined by the UIC 519 standard (EN 15302) is used, approximating the relationship between ∆r and the amplitude of the lateral displacement.

For a wheel with a conical profile, the equivalent conicity is simply the half-angle of the tread of the cone. For wheels with arbitrary profiles, the equivalent conicity is defined as the tangent of the angle of the cone of a purely conical profile whose lateral movement produces a kinematic oscillation with the same wavelength as the pair mounted with arbitrary profiles. This definition is only applicable in the analysis on straight paths and large radius curves (Rc ≥ 2500 m).

In this way, the equivalent conicity is a parameter used to characterize the geometry of the wheel-rail contact and establishes the criterion for assessing the influence of the contact on the vehicle's driving stability on a straight track. 

<img align="right" width="500" src="https://user-images.githubusercontent.com/53323058/243651913-bc95cea4-cfab-4a51-bb11-09afd7b4a07c.png">

### Wheel's conicity importance
  
The value of the wheel conicity provides quantitative information on the influence of the wheel-rail interaction on the quality of ride comfort and the dynamic stability of the rail vehicle.
  
High taper conicity (shortest wavelength at comparative constant speed):
  * Increase the compensating effect on the centrifugal force generated on curved paths, reducing the risk of derailment.
  * Reduce driving comfort on a straight track due to the presence of greater lateral accelerations.
  
Low taper conicity (longer wavelength at comparative constant speed):
  * Increase the frequency of occurrence of the flange hit during circulation in slight curves, causing excessive wear on the wheel profile.
  * Decrease the lateral acceleration, increasing ride quality on straight paths.

### Brief summary of the numerical estimation of equivalent conicity
  
The method proposed by the EN 15302 standard is based on the analysis of the kinetic movement of a pair mounted on a straight track or large radius curved paths. The determination of the equivalent conicity is performed by numerically integrating of the ∆r function, representing the longitudinal distance traveled in terms of lateral displacement, x = f(y). From the latter, the wavelength λ is obtained for a lateral displacement in the interval [1-7 mm] with increments of ∆y ≤ 0.1 mm, to finally determine the equivalent conicity by using the Klingel's formula for a conical profile whose kinematic movement presents the same wavelength.
  
### The main application
  
The software capabilities focus on the characterization of wheel-rail rigid contact through the aid of following specific calculations:

> * Potential wheel-rail `contact points detection` by mean of rigid profiles penetration comparison;
> * tan(γa) --> `contact angle` between wheel and rail (formerly, angle of the tangent to the point of contact);
> * ∆r --> `rolling-radius difference function`, at the predefined lateral amplitude interval;
> * tan(γc)=f(λ) --> `equivalent conicity` for each movement wavelength of a (equivalent) conical profile, at a specific lateral displacement (wave amplitude).

<img align="right" width="500" src="https://user-images.githubusercontent.com/53323058/243652157-d5a8055d-f0d0-4673-9b5b-dc28aefd47c8.png">
  
Within the described method, the following assumptions are used:
  
* Both the wheel and the rail are considered rigid;
* Wheels have revolution symmetry and are represented by a single profile (for each wheel);
* Rails are straight, parallel to each other and represented by a single profile (for each rail);
* The wheel does not penetrate the rail: only the point of rigid contact is considered.

The entire procedure lies on the ∆r function determination accuracy, either for measured real profiles or a theoretical mathematical representation.
  
* The reference profiles used, whose are defined for benchmark calculations in the Annex D to test the algorithm in a wide range of conditions, have been smoothed by cubic interpolation which allows the location of the contact points to calculate the rolling radius difference as a function of the lateral position of the wheelset. 
  
The main factors that influence the determination of the equivalent conicity have been included, such as:
  
* Geometry of the profiles (taper's rolling radii and transversal section data);
* Track gauge (see the picture with references on the main GUI);
* Inclination angle of both rails. 
  
#### Mandatory TODO list
  
Other factors, not implemented up to the present time, and that increase the complexity of the process calculation, will be considered in the near future:
  
* The use of worn profiles as input cases;
* Track global irregularities: layout deviations, such as the unevenness, gauge difference and alignment. 

#### Note about software output results
  
From the processed conicity value, the stability of the vehicle can be evaluated depending on longitudinal running velocity, ensuring the generation of the required restoring forces when the formation goes through an open curve and thus increasing safety against derailment. Nevertheless, for real profiles and after a long period of use, the equivalent taper conicity can be reach values in a higher range due to excessive wear, and must be critically evaluated by a trained professional.       
</div>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ROADMAP -->
## Roadmap

- [x] Improved potential contact points detection 
- [x] Asymmetric cases implementation
- [x] Stand-alone unified version (equivalent conicity add-on)
- [x] Implementation of output options (PDFBox library)     
- [x] Improved error events handling
- [ ] Increase profiles database (APTA/ARR standards & worn cases)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://user-images.githubusercontent.com/53323058/230575198-fa1acbf4-8f82-4d8e-b245-3979276bc240.png
[linkedin-url]: https://www.linkedin.com/in/criogenox/
