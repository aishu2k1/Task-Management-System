import { ScrollArea, Text, Tabs, rem, Container, Card, GridCol, Grid, Modal, Stack, Space, Group, Transition, ActionIcon, Button } from '@mantine/core';
import { useState } from 'react';
import {
  IconBadge,
  IconMenu2,
  IconSubtask,
  IconCalendar,
} from '@tabler/icons-react';

import { HabitsComponent  } from './HabitsComponent';
import { TasksComponent } from './TasksComponent';
import { CalenderComponent } from './CalenderComponent';



export function TabsComponent() {
  const [opened, setOpened] = useState(true);
  const iconStyle = { width: rem(12), height: rem(12) };

  return (
    <>
      <Tabs defaultValue="calender" pt={2} orientation="vertical" placement="left" pr={30} >
        <Tabs.List>
          <Tabs.Tab value="calender" leftSection={<IconCalendar style={iconStyle}/>}  onClick={() => setOpened(false)}>
            <Text size='md'>Calender</Text>
          </Tabs.Tab>
          <Tabs.Tab value="habits" leftSection={<IconBadge style={iconStyle}/>} onClick={() => setOpened(true)}>
            <Text size='md'>Habits</Text>
          </Tabs.Tab>
          <Tabs.Tab value="tasks" leftSection={<IconSubtask style={iconStyle} />}  onClick={() => setOpened(false)}>
            <Text size='md'>Tasks</Text>
          </Tabs.Tab>
        </Tabs.List>

        <Tabs.Panel value="habits" pl={20}>
            <HabitsComponent />
        </Tabs.Panel>

        <Tabs.Panel value="tasks" pl={20}>
          <TasksComponent />
        </Tabs.Panel>

        <Tabs.Panel value="calender" pl={20}>
          <CalenderComponent />
        </Tabs.Panel>
      </Tabs>
    </> 
  );
}
