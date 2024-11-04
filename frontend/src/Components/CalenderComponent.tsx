import {GridCol, Grid, Card, ScrollArea, Stack, Checkbox, Space, Group, HoverCard, Button, Text, Modal } from '@mantine/core';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DemoContainer } from '@mui/x-date-pickers/internals/demo';

import { useState } from 'react';

const HabitsData = [
    {
        name: "habit name",
        description: "habit description",
        status: false,
        category: "something"
    },
    {
        name: "habit name",
        description: "habit description",
        status: false
    },
    {
        name: "habit name",
        description: "habit description",
        status: false
    },
    {
        name: "habit name",
        description: "habit description",
        status: false
    },
    {
        name: "habit name",
        description: "habit description",
        status: false
    },
    {
        name: "habit name",
        description: "habit description",
        status: false
    },
    
]

export function CalenderComponent() {
    const [value, setValue] = useState<Date | null>(null);
    const habits = HabitsData.map((item, index) => (
        <GridCol span={3}>    
            {/* <Chip size="xl"> */}
                <Card 
                shadow="md"
                padding="md"
                >
                    <Group justify='space-between'>
                    <Stack>
                    <Text fw={1000} size="lg" mt="md">
                        {item.name}
                    </Text>
                    <Text>
                        {item.description}
                    </Text>
                    </Stack>
                    <Checkbox size='xl'/>
                    </Group>
                    <Space h="10"/>
                    
            </Card> 
            {/* </Chip> */}
          
        </GridCol>
    ))
    return (
        <>  
            <ScrollArea h={800}>
                <Group justify='center'>
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DemoContainer components={['DatePicker']}>
                            <DatePicker label="Pick Date" format="DD-MM-YYYY"/>
                        </DemoContainer>
                    </LocalizationProvider>
                </Group>
                <Space h={20}></Space>
                <Grid>
                    {habits}
                </Grid>
            </ScrollArea>
        </>
    )
}