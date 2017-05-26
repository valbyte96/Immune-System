IMMUNE SYSTEM PUCKS SYSTEM
VAL MCCULLOCH AND SILVANA SACA

We created an evolutionary multi-agent environment based on the Pucks system developed by Professor Lee Spector. Our project consists of .clj files, so you will need leiningen to access them. Detailed instructions on running Pucks can be found in Professor Spector’s GitHub, at: https://github.com/lspector/pucks . You need not download Professor Spector’s original zip file, as we changed a lot of the physics, so simply run it out of our zipped file using leiningen, typing the following into the command line:
$ lein run pucks.worlds.ai.world1


Our world is a simulated immune system, which consists of three different types of agents: viruses (user agents), red blood cells (vent agents), and white blood cells (zapper agents). Each of these is born with a genome in their memory, carrying an identifying protein (under the key :kill) that other pucks can use to determine whether they should kill that agent. Initially, agents have the following predetermined values:
White Blood Cells (Zapper): 1
Virus (User): 2
Red Blood Cells (Vent): 3


White blood cells kill viruses (1 kills 2), and viruses kill vents (2 kills 3). White blood cells are immune. Viruses succeed if they can outlive all the red blood cells, and the body succeeds if the white blood cells kill all the viruses before mutation occurs (or if mutation is unsuccessful).

Viruses have a low chance of mutation, wherein their :kill value randomly changes to disguise itself as a part of the body, or, 1/3 of the time, remains the same. This is to account for times when mutation may occur but may not be significant enough to have an impact on a virus’s life expectancy. Mutation occurs at spawning. If a virus does not mutate at inception, then it inherits its parent’s :kill value. The system is single parent, because the cell is undergoing binary fission or replicating through division. We account for a fitness function, because viruses that aren’t fit or immune will be selected against automatically by our White Blood Cells (or other viruses if their :kill value is 3). 

We altered the underlying physics of the Pucks System so that the pucks live forever until they are killed. Thus, energy is still a limited resource, but it isn’t depleted by motion or life span. For justification on how our project is a MAS see our Multi-Agent System report that we turned in earlier this semester. 

Silvana and I think we deserve an A in this class, because we have met all of the course goals. We understand the difference between MAS and other intelligent systems. We successfully interacted with and altered a virtual environment so that it evolves multi-agent systems. I, Val, learned a new language and the concepts of evolutionary computation. Silvana learned how to implement concepts of evolutionary computation into a graphical interface. 

We greatly enjoyed this course and working together!
