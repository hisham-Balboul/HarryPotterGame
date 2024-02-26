# Harry Potter: The Return of the Triwizard Tournament

## Background & Story

Harry Potter is a young boy who learns on his eleventh birthday that he is the son of two late powerful wizards and thus possesses unique magical powers. Accordingly, his life is turned around when he is summoned to join the wizard’s boarding school Hogwarts. Alongside his new found friends in the Gryffindor house he learns how to become an actual wizard to one day defeat his mortal enemy Voldemort.
The 3 other wizard houses in Hogwarts are Slytherin, Hufflepuff and Ravenclaw. In his fourth year of study, he finds his name mysteriously added to the goblet of fire, which is an unbiased device for selecting the participants in the magical contest: the Triwizard Tournament. The champions compete in three tasks designed to test magical ability, intelligence and courage. Champions competed for the eternal honour and glory of winning the tournament, for the Triwizard Cup, and a monetary prize.

## Game Overview

The game is a role-playing game (RPG) featuring the Triwizard Tournament from the Harry Potter series. The game consists of different maps representing the three tasks of the tournament. The champions will compete against each other at the same time inside each map. The champions will take on the roles of Hogwarts students i.e. apprentice wizards.

### Gameplay

The game play consists of 3 environments i.e. maps, corresponding to the 3 tasks of the tournament. Each environment has a different objective and thus a different playstyle.
All maps are represented as a 10 x 10 grid that the champions can navigate. Movement is allowed in four directions (up,down,left,right). Obstacles and walls prevent the champions from going through them.
Each map has some potions hidden in it which can be collected by the champions.
Before starting the game each champion must choose 3 spells from all the available spells to be assigned to him during the tournament.

### Tasks

#### Task 1: 
The champions need to get their respective golden eggs while trying to avoid the dragon’s attacks
and fire blasts. Each champion starts from their corner of the map and the golden eggs are placed in the centre of the map (i.e. cell 4,4). The obstacles in the map can be removed/moved using specific spells. At each champion’s turn the dragon first will choose (randomly) to attack two cells from:
1. The cells adjacent to the champion’s current location.
2. The cell the champion is currently in. 
The dragon’s fire affects any champion standing in the targeted cells. If a champion goes to, or stays in, a cell the dragon has decided to attack, he/she gets hit by the dragon’s fire and loses a certain amount of HP. So, the sequence in each player’s turn is: dragon chooses cells to attack then the player makes a move and finally the dragon performs the attack. The game keeps going until all champions have either reached the egg or died(HP reaches zero). Only champions who make it to the egg can proceed to the second task.

#### Task 2:
 The champions have something stolen from them and hidden somewhere in the lake i.e. map. Each champion’s treasure is hidden in a different cell. The champions navigate the map trying to reach their treasures. This map has merpeople that can be defeated using specific spells. Merpeople attack champions in adjacent cells to prevent them from getting to their treasures. A champion wins the task upon reaching his specific target. Only then can a champion proceed to the third task. Champions whose HP reaches 0 die and thus fail the task and are prevented from continuing the tournament. Keeping champions’ finishing order is important because it will affect how they are placed in the third task.

#### Task 3:
 The map is designed as a maze, which means there are walls that the champions cannot go through nor remove with spells (unlike obstacles). This map has obstacles that can be removed/moved using specific spells. The champions playing order in the the 3rd task depends on the order in which they have finished the second task. All players try to reach the Triwizard Cup positioned within the maze in order to win the tournament. The champion who reaches it first wins thus ending the game!

### Turns

The order in which the champions start playing in the first and second task is randomly chosen. In the third task their ordering depends on their completion order of the previous task.
Only the champions qualified to participate in the current task are placed in the map. Their placement starts with the bottom left corner of the map and continues by filling the map corners in a counterclockwise manner till the final champion is placed in the top left corner. The third task is an exception to this, where the whole map, excluding the potions, is read from a csv file. The
potions are placed randomly like in the first and second task.
The state of the champions is reset at the start of each task i.e. their HP and IP are restored to their default values. The turns alternate between the champion. Each turn a champion is allowed one move which can be casting a spell or moving one step within the map. If a special trait that allows for something else is activated, the trait’s functionality should be realized.

### Obstacles

The obstacles preventing the champion’s movement can either be a physical object in Task 1 and 3 or a merperson (the generic species of a mermaid) in Task 2. The obstacles are randomly placed in the maps of the first and second task but read from the csv file in the third task. The obstacles are destroyed whenever their HP reaches 0.

### Game flow

The players should be able to create and choose between different houses to start a game. The external game player will alternate playing as the four champions i.e. the engine does not play as the champions.
The game starts with the first task and the champions can only progress through the game by successfully finishing tasks.
The game ends with the completion of the three tournament tasks and only one champion can win the tournament. If at any point in time there are no more remaining champions participating in the tournament then the whole game ends. In case only one champion is remaining before finishing the 3 tasks, he should proceed with the gameplay alone until he wins all three tasks, and thus the tournament, or dies.

### Characters

The game mainly follows an RPG design. Champions are the players participating in the tournament. These champions are wizards which may belong to four different houses: Gryffindor, Slytherin, Hufflepuff and Ravenclaw. Champions belonging to each house have different statistics (such as health and intelligence points) and each house gives its students different traits according to the different tournament tasks. In addition to the necessary attributes for maintaining the game flow, wizards have:
- Name
- Health Points (HP): The health points represent how much damage the champion can take.
Champions can regenerate their health by casting healing spells.
- Intelligence Points (IP): The intelligence points represent the champion’s intelligence which is
consumed when casting spells. Champions can restore their IP upon encountering potions during
gameplay.
- List of spells and inventory: The list of spells currently available to the champion and the items in
the possession of the wizard; mainly potions.
Depending on the wizard’s house the initial stats are as follows:

#### Wizard Stats:

| House / Stat | HP | IP  |
| ---------- | ---- | --- |
| Gryffindor | 900  | 500 |
| Slytherin  | 850  | 550 |
| Hufflepuff | 1000 | 450 |
| Ravenclaw  | 750  | 700 |

#### Special Traits:

Wizards who participate in the tournament i.e. champions get special traits depending on their house and the tournament task. These traits act like a special action that can be applied only by champions belonging to the house and only during a certain task. However, activating a trait is not counted as a move and thus can be applied alongside casting a spell or navigating the map. An exception to this is champions of the Slytherin house, whose trait is counted a move. Upon activating a special trait the champion needs to wait a specific number of game turns (designated “trait cooldown”) before being allowed to activate it again. 
The following table illustrates these traits:

| House/ Map | Task 1 | Task 2 | Task 3 |
| ---------- | ------ | ------ | ------ |
| Gryffindor | This turn, the champion can make 2 moves instead of 1 (Cooldown: 4) | This turn, the champion can make 2 moves instead of 1 (Cooldown: 4) | This turn, the champion can make 2 moves instead of 1 (Cooldown: 4) |
| Slytherin |  This turn, the champion can choose between: 1. Jumping over a cell containing an obstacle without destroying or moving the obstacle; provided that he ends up in an empty cell. 2. Traversing two cells instead of one (Cooldown: 6) | This turn, the champion’s movement traverses two cells instead of one; provided that he ends up in an empty cell (Cooldown: 4) | This turn, the champion can choose between: 1. Moving through a wall given that the cell he ends up in is not another wall 2. Jumping over a cell containing an obstacle without destroying or moving the obstacle; provided that he ends up in an empty cell. 3. Traversing two cells instead of one (Cooldown: 10) |
| Hufflepuff | This turn, the dragon does not attack (Cooldown: 3) | This turn, the merpeople will not do any damage (Cooldown: 6) | Attacks from other champions will only deal half the damage (Always activated, no cooldown) |
| Ravenclaw | This turn, the champion is shown where the dragon is going to attack (Cooldown: 5) | This turn, the champion is given a hint on where the target is hidden relative to the current position (left or right + up or down) (Cooldown: 7) | This turn, the champion is given a hint on where the cup is hidden relative to the current position (left or right + up or down) (Cooldown: 7) |

### Magic Components

A wizard is not a wizard without magic. Magic is realized through spells and potions.

### Spells

Spells are cast by wizards for different purposes. Spells can either damage, heal or relocate. Each spell has a name as well as a cost which it consumes from the IP of the wizard who casts it. Also, a wizard needs to wait for a certain amount of turns (cooldown) before being able to cast a specific spell again. Damage and healing spells have damage or healing amount while relocating spells have a maximum range with which a wizard can relocate an object to.
1. Relocating spells: Relocating spells can move obstacles/monsters or other champions in any
moving direction (up, down, left, right) with the designated relocation range.
2. Damaging spells: Champions can choose to cast damaging spells on one of the cells adjacent to
them thus damaging the object within said targeted cell, if any. The value of the damage
depends on the strength of the spell used. The damage value is deducted from the HP of the
target of the spell i.e. the object (champion or obstacle) in the targeted cell.
3. Healing spell: These spells heal the champion casting them with the healing amount of the
spell.

### Potions

Wizards can encounter potions while navigating any map. Potions are stored in the wizard’s inventory and can be used to restore and increase IP when needed. Potions have a name and amount by which they restore the IP.
