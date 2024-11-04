import { ScrollArea, Text, Tabs, rem, Container, Card, GridCol, Grid, Modal, Stack, Space, Group, Transition, ActionIcon, Button } from '@mantine/core';
import { useState, useEffect } from 'react';
import {
  IconNumber0,
  IconNumber1Small,
  IconNumber1,
  IconNumber2Small,
  IconNumber3Small,
  IconNumber3,
  IconNumber4Small,
  IconNumber5Small,
  IconNumber6Small,
  IconNumber7Small,
  IconNumber8Small,
  IconNumber9Small,
  IconNumber10Small,
  IconNumber11Small,
  IconNumber12Small,
  IconNumber13Small,
  IconNumber14Small,
  IconNumber15Small,
  IconNumber16Small,
  IconNumber17Small,
  IconNumber18Small,
  IconNumber19Small,
  IconNumber20Small,
  IconNumber21Small,
  IconNumber22Small,
  IconNumber23Small,
  IconNumber24Small,
  IconNumber25Small,
  IconNumber26Small,
  IconNumber27Small,
  IconNumber28Small,
  IconNumber29Small,
} from '@tabler/icons-react';

import { useDisclosure } from '@mantine/hooks';

const iconMap = [
    IconNumber1Small,
    IconNumber2Small,
    IconNumber3Small,
    IconNumber4Small,
    IconNumber5Small,
    IconNumber6Small,
    IconNumber7Small,
    IconNumber8Small,
    IconNumber9Small,
    IconNumber10Small,
    IconNumber11Small,
    IconNumber12Small,
    IconNumber13Small,
    IconNumber14Small,
    IconNumber15Small,
    IconNumber16Small,
    IconNumber17Small,
    IconNumber18Small,
    IconNumber19Small,
    IconNumber20Small,
    IconNumber21Small,
    IconNumber22Small,
    IconNumber23Small,
    IconNumber24Small,
    IconNumber25Small,
    IconNumber26Small,
    IconNumber27Small,
    IconNumber28Small,
    IconNumber29Small,
  ]


const HabitsData = [
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'Mon', date:1, status: 1}, 
        {day:'Tue', date:1, status: 1}, 
        {day:'Wed', date:1, status: 1}, 
        {day:'Thu', date:1, status: 1}, 
        {day:'Fri', date:1, status: 1},
        {day:'Sat', date:1, status: 1}, 
        {day:'Sun', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1},
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 2}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1},
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'tue', date:1, status: 1}, 
        {day:'wed', date:1, status: 1}, 
        {day:'thu', date:1, status: 1}, 
        {day:'fri', date:1, status: 1},
        {day:'sat', date:1, status: 1}, 
        {day:'sun', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1},
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:15, status: 1}, 
        {day:'mon', date:20, status: 1}, 
        {day:'mon', date:13, status: 2}, 
        {day:'mon', date:12, status: 1}, 
        {day:'mon', date:12, status: 1},
        {day:'mon', date:31, status: 1}, 
        {day:'mon', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'tue', date:1, status: 0}, 
        {day:'wed', date:1, status: 1}, 
        {day:'thu', date:1, status: 2}, 
        {day:'fri', date:1, status: 2},
        {day:'sat', date:1, status: 1}, 
        {day:'sun', date:1, status: 0} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1},
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1} 
      ]
    },
    {
      title: 'habitName1', 
      descrition: "a lot of text i guess idk",
      category: "lol", 
      lastWeek: [ 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 2}, 
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1},
        {day:'mon', date:1, status: 1}, 
        {day:'mon', date:1, status: 1} 
      ]
    },
  ]

export function HabitsComponent() {
    const [opened, setOpened] = useState(true);
    const [categories, setCategories] = useState(null);
    useEffect(() => {
      const fetchData = async () => {
        try {
            const response = await fetch('http://localhost:8080/users/root/categories');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const jsonData = await response.json();
            setCategories(jsonData); 
            console.log(categories)
        } catch (err) {
            console.error('Error fetching data:', err);
        }
        };
        fetchData()
    }, [])
    const IconNumber : React.FC<{ iconNumber : number }> = ({iconNumber}) => {
        if (iconNumber == 30) {
          return (
            <>
              <IconNumber3 stroke={3} size={10}/><IconNumber0 stroke={3} size={50}/>
            </>
          )
        }
        if (iconNumber == 31) {
          return (
            <>
              <IconNumber3 stroke={3} size={50}/><IconNumber1 stroke={3} size={50}/>
            </>
          )
        }
        const IconComponent = iconMap[iconNumber-1]
        return (
          <IconComponent size={50}/>
        )
      }

    const habits = HabitsData.map((item, index) => (
        <GridCol span={6}>    
          <Card 
            shadow="md"
            padding="xl"
            component="a"
            >
                <Grid>
                {item.lastWeek.map((item, index) => (
                  <Grid.Col span={1.714}> 
                    <Stack>
                      <Text pl={5}>{item.day}</Text>
                      <ActionIcon variant="outline" size={40}>
                        <IconNumber iconNumber={item.date} />
                      </ActionIcon>
                    </Stack>
                    
                  </Grid.Col>
                ))}
                </Grid>
            <Space h="20"/>
            <Group justify='space-between'>
              <Text fw={1000} size="lg" mt="md">
                {item.title}
              </Text>
              <Text fw={1000} size="lg" mt="md" pr={20}>
                {item.category}
              </Text>
            </Group>
            <Space h="10"/>
            <Text>
              {item.descrition}
            </Text>
          </Card> 
        </GridCol>
      ))

    const [openedCreateHabit, { open, close }] = useDisclosure(false);

    return (
        <>
            <ScrollArea h={800}>
                <Grid>

                {habits}

                </Grid>
            </ScrollArea>

            <Modal opened={openedCreateHabit} onClose={close} title="Create New Habit" centered>
                Modal content 
            </Modal> 

            <Group justify='flex-end'>

                <Button mt={10} mr={10} variant="outline" onClick={open}>Create new Habit</Button>

          </Group>
        </>
    )
}